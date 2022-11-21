package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firstapp.databinding.ActivityHackaton0Binding

class Hackaton0 : AppCompatActivity() {

    private lateinit var binding: ActivityHackaton0Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHackaton0Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.entrada.setOnClickListener {
            val intent = Intent(this, Hackaton1::class.java)
            startActivity(intent)
        }
        binding.troll.setOnClickListener {
            Toast.makeText(this, "...", Toast.LENGTH_SHORT).show()
        }
    }
}