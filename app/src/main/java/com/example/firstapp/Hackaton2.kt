package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firstapp.databinding.ActivityHackaton2Binding

class Hackaton2 : AppCompatActivity() {

    private lateinit var binding: ActivityHackaton2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHackaton2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.AmunikeButton.setOnClickListener {
            val intent = Intent(this, Hackaton3::class.java)
            startActivity(intent)
        }

        binding.button3.setOnClickListener {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
        }
        binding.button4.setOnClickListener {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
        }
        binding.button5.setOnClickListener {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
        }
    }
}