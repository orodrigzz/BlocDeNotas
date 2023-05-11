package com.blocdenotes.oscarrodriguez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import java.text.SimpleDateFormat
import java.util.*

class AddEditNoteActivity : AppCompatActivity() {
    //Initzialitzo variables del layout
    private lateinit var noteTitleEdt: EditText
    private lateinit var noteEdt: EditText
    private lateinit var saveBtn: Button

    //Initzialitzo variables del viewmodel i l'id de la ntoa
    private lateinit var viewModal: NoteViewModal
    private var noteID = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)
        //Initzialitzo el viewmodel
        viewModal = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModal::class.java)

        //Assigno Initzialitzo les variables
        noteTitleEdt = findViewById(R.id.nomNota)
        noteEdt = findViewById(R.id.descNota)
        saveBtn = findViewById(R.id.guardarBttn)

        //Agafem l'informació que acabem de passar pel intent
        val noteType = intent.getStringExtra("noteType")
        if (noteType.equals("Edit")) {
            //Settejem l'ifnormació
            val noteTitle = intent.getStringExtra("noteTitle")
            val noteDescription = intent.getStringExtra("noteDescription")
            noteID = intent.getIntExtra("noteId", -1)
            saveBtn.text = "Actualitzar"
            noteTitleEdt.setText(noteTitle)
            noteEdt.setText(noteDescription)
        } else {
            saveBtn.text = "Guardar"
        }

        //Listener on click al botó de guardar -> es guarda / actualitza
        saveBtn.setOnClickListener {
            //Agafem el titol i la descripcio de la nota
            val noteTitle = noteTitleEdt.text.toString()
            val noteDescription = noteEdt.text.toString()
            if (noteType.equals("Edit")) {
                //Si la nota ja està creada s'actualitza
                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDateAndTime: String = sdf.format(Date())
                    val updatedNote = Note(noteTitle, noteDescription, currentDateAndTime)
                    updatedNote.id = noteID
                    viewModal.updateNote(updatedNote)
                    Toast.makeText(this, "Nota actualitzada", Toast.LENGTH_LONG).show()
                }
            } else {
                //Si la nota no està creada es crea
                if (noteTitle.isNotEmpty() && noteDescription.isNotEmpty()) {
                    val sdf = SimpleDateFormat("dd MMM, yyyy - HH:mm")
                    val currentDateAndTime: String = sdf.format(Date())
                    viewModal.addNote(Note(noteTitle, noteDescription, currentDateAndTime))
                    Toast.makeText(this, "$noteTitle afegida", Toast.LENGTH_LONG).show()
                }
            }
            //Obrim la main activity després de guardar/actualitzar la nostra nota
            startActivity(Intent(applicationContext, MainActivity::class.java))
            this.finish()
        }
    }
}