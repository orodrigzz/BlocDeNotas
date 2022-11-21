package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firstapp.databinding.ActivityHackaton1Binding

class Hackaton1 : AppCompatActivity() {

    private lateinit var binding: ActivityHackaton1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHackaton1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.QatarButton.setOnClickListener {
            val intent = Intent(this, Hackaton2::class.java)
            startActivity(intent)
        }
        binding.button.setOnClickListener {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
        }
        binding.button1.setOnClickListener {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
        }

    }
}