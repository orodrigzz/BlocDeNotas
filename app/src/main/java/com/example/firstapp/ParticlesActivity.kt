package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firstapp.databinding.ActivityParticlesBinding

class ParticlesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityParticlesBinding

    val addBtton = binding.addButton

    private var particles = listOf("Nota1",
        "Nota2",
        "Nota3",
        "Nota4",
        "Nota5",
        "Nota6",
        "Nota7",
        "Nota8",
        "Nota9",
        "Nota10",
        "Horario",
        "Recompensas",
        "Buses",
        "Prácticas")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityParticlesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.particlesRecyclerView.adapter = ParticlesRecyclerViewAdapter(particles,this)

        addBtton.setOnClickListener {
            Toast.makeText(this, "AÑADIR NOTA", Toast.LENGTH_LONG).show()
        }
    }
}