package com.example.firstapp.particleslist

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.MainActivity
import com.example.firstapp.databinding.ItemParticleBinding

class ParticlesRecyclerViewAdapter(val particles: List<String>) :
    RecyclerView.Adapter<ParticlesRecyclerViewAdapter.ParticleVH>() {

    inner class ParticleVH(binding: ItemParticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val name = binding.particleName
        val image = binding.lapizImage
        val deleteBtn = binding.deleteButton
        val layout = binding.notaLayout
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticleVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemParticleBinding.inflate(layoutInflater)

        binding.deleteButton.setOnClickListener {
            // Toast.makeText(this, "Hola classe", Toast.LENGTH_LONG).show()
        }

        binding.notaLayout.setOnClickListener {
            //val intent = Intent(this, MainActivity::class.java)
            //startActivity(intent)
        }
        return ParticleVH(binding)
    }

    override fun onBindViewHolder(holder: ParticleVH, position: Int) {
        val particle = particles[position]
        holder.name.text = particle
    }

    override fun getItemCount(): Int {
        return particles.size
    }

}