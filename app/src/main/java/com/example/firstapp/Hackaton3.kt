package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstapp.databinding.ActivityHackaton3Binding

class Hackaton3 : AppCompatActivity() {

    private lateinit var binding: ActivityHackaton3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHackaton3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //binding.AmunikeButton.setOnClickListener {
        //    val intent = Intent(this, Hackaton3::class.java)
        //    startActivity(intent)
        //}
    }
}