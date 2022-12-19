package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.databinding.ActivityNotesBinding

class NotesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNotesBinding
    private val llmanager = LinearLayoutManager(this)

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

    private var lista = notes.toMutableList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.particlesRecyclerView.adapter = NotesRecyclerViewAdapter(lista,this)

        binding.addButton.setOnClickListener {
            createNota()
        }
    }

    private fun createNota(){
        val nota = Nota(
            "NotaCreada"
        )

        lista.add(index = 3, nota.toString())
        binding.particlesRecyclerView.adapter?.notifyItemInserted(3)
        llmanager.scrollToPositionWithOffset(3,10)

    }
}