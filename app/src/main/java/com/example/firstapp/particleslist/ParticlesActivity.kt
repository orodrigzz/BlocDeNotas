package com.example.firstapp.particleslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstapp.databinding.ActivityParticlesBinding

class ParticlesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityParticlesBinding

    private val particles = listOf("Nota1",
        "Nota2",
        "Nota3",
        "Nota4",
        "Nota5",
        "Nota6",
        "Nota7",
        "Nota8",
        "Nota9",
        "Nota10",
        "Nota11",
        "Nota12")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityParticlesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.particlesRecyclerView.adapter = ParticlesRecyclerViewAdapter(particles)
    }
}