package com.blocdenotes.oscarrodriguez

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModal(application: Application) : AndroidViewModel(application) {
    //Variable per a totes les notes i el repositori
    val allNotes: LiveData<List<Note>>
    private val repository: NoteRepository

    //Initzialitem el dao per a comunicarnos amb la bdd, el repositori i les notes
    init {
        val dao = NoteDatabase.getDatabase(application).getNotesDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

    //funció per a borrar nota que truca a la funció del repositori
    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }

    //funció per a actualitzar nota que truca a la funció del repositori
    fun updateNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(note)
    }

    //funció per a afegir nota que truca a la funció del repositori
    fun addNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }
}