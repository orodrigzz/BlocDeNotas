package com.blocdenotes.oscarrodriguez

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity(), NoteClickInterface, NoteClickDeleteInterface {
    //Initzialitzo les variables del view model, recyclerV y el botó d'afegir nota
    private lateinit var viewModel: NoteViewModal
    private lateinit var notesRV: RecyclerView
    private lateinit var addBttn: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initzialitzo les variables
        notesRV = findViewById(R.id.notesRecyclerView)
        addBttn = findViewById(R.id.AfegirNotaBttn)

        //Assigno el layout
        notesRV.layoutManager = LinearLayoutManager(this)

        //Initzialitzo l'adapter
        val noteRVAdapter = NoteRVAdapter(this, this)
        notesRV.adapter = noteRVAdapter

        //Initzialitzo el view model
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModal::class.java)

        //truco mètode de totes les notes per observar els canvis a la llista.
        viewModel.allNotes.observe(this) { list ->
            list?.let {
                noteRVAdapter.updateList(it)
            }
        }

        //Listener on click al botó per a mostrar la pantalla de afegir nota
        addBttn.setOnClickListener {
            val intent = Intent(this@MainActivity, AddEditNoteActivity::class.java)
            startActivity(intent)
            this.finish()
        }
    }

    //Passem informació de la nota al intent
    override fun onNoteClick(note: Note) {
        val intent = Intent(this@MainActivity, AddEditNoteActivity::class.java)
        intent.putExtra("noteType", "Edit")
        intent.putExtra("noteTitle", note.noteTitle)
        intent.putExtra("noteDescription", note.noteDescription)
        intent.putExtra("noteId", note.id)
        startActivity(intent)
        this.finish()
    }

    //truca a la funció del view model de borrar nota
    override fun onDeleteIconClick(note: Note) {
        viewModel.deleteNote(note)
        Toast.makeText(this, "${note.noteTitle} borrada", Toast.LENGTH_LONG).show()
    }

}