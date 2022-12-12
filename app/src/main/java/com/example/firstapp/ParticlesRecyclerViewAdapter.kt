package com.example.firstapp

import android.content.Context
//import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemParticleBinding

class ParticlesRecyclerViewAdapter(private val particles: List<String>, private val context : Context) :
    RecyclerView.Adapter<ParticlesRecyclerViewAdapter.ParticleVH>() {

    private var lista = particles.toMutableList()

    inner class ParticleVH(binding: ItemParticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val name = binding.particleName
        val deleteBtn = binding.deleteButton
        val noteLayout = binding.notaLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticleVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemParticleBinding.inflate(layoutInflater)
        return ParticleVH(binding)
    }

    override fun onBindViewHolder(holder: ParticleVH, position: Int) {
        val particle = particles[position]
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
        return particles.size
    }

}