package com.example.firstapp

import android.content.Context
//import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemNoteBinding

class NotesRecyclerViewAdapter(private val notes: List<String>, private val context : Context) :
    RecyclerView.Adapter<NotesRecyclerViewAdapter.NoteVH>() {

    private var lista = notes.toMutableList()

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

    override fun onBindViewHolder(holder: NoteVH, position: Int) {
        val particle = notes[position]
        holder.name.text = particle

        holder.deleteBtn.setOnClickListener {
            lista.removeAt(position)
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
        return notes.size
    }

}