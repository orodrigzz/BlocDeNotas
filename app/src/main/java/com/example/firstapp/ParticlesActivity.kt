package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.widget.Toast
import com.example.firstapp.databinding.ActivityParticlesBinding

class ParticlesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityParticlesBinding

    //private val addBtton = binding.addButton

    private var particles = listOf(
        "NotaPredeterminada1",
        "NotaPredeterminada2",
        "NotaPredeterminada3",
        "NotaPredeterminada4",
        "NotaPredeterminada5",
        "NotaPredeterminada6",
        "NotaPredeterminada7",
        "NotaPredeterminada8",
        "NotaPredeterminada9",
        "NotaPredeterminada10",
        "NotaPredeterminada11",
        "NotaPredeterminada12",
        "NotaPredeterminada13")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityParticlesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.particlesRecyclerView.adapter = ParticlesRecyclerViewAdapter(particles,this)

        //addBtton.setOnClickListener {
        //    Toast.makeText(this, "AÑADIR NOTA", Toast.LENGTH_LONG).show()
        //}
    }
}