package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstapp.databinding.ActivityNotesBinding
//import android.widget.Toast

class NotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesBinding

    //private val addBtton = binding.addButton

    private var notes = listOf(
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

        binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.particlesRecyclerView.adapter = NotesRecyclerViewAdapter(notes,this)

        //addBtton.setOnClickListener {
        //    Toast.makeText(this, "AÑADIR NOTA", Toast.LENGTH_LONG).show()
        //}
    }
}