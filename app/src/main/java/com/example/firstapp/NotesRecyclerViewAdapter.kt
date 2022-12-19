package com.example.firstapp

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemNoteBinding
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.interstitial.InterstitialAd

class NotesRecyclerViewAdapter(private val lista: MutableList<String>, private val context : Context) :
    RecyclerView.Adapter<NotesRecyclerViewAdapter.NoteVH>() {

    private var ad: InterstitialAd? = null

    inner class NoteVH(binding: ItemNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val name = binding.noteName
        val deleteBtn = binding.deleteButton
        val noteLayout = binding.notaLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemNoteBinding.inflate(layoutInflater)
        return NoteVH(binding)
    }

    override fun onBindViewHolder(holder: NoteVH, @SuppressLint("RecyclerView") position: Int) {
        val note = lista[position]
        holder.name.text = note

        holder.deleteBtn.setOnClickListener {

            ad?.let {
                it.fullScreenContentCallback = object : FullScreenContentCallback() {
                    override fun onAdDismissedFullScreenContent() {
                        lista.removeAt(position)
                        notifyItemRemoved(position)
                        ad = null
                    }

                    override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                        lista.removeAt(position)
                        notifyItemRemoved(position)
                        ad = null
                    }
                }
            }?:lista.removeAt(position)
            notifyItemRemoved(position)
        }

        holder.name.setOnClickListener {
            Toast.makeText(context, "CAMBIAR NOMBRE", Toast.LENGTH_LONG).show()
        }

        holder.noteLayout.setOnClickListener {
            Toast.makeText(context, "ACCEDER NOTA", Toast.LENGTH_LONG).show()
            //val intent = Intent(this, MainActivity::class.java)
            //startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return lista.size
    }

}