package com.blocdenotes.oscarrodriguez

import androidx.lifecycle.LiveData

//Una clase de repositorio nos proporcionará una API limpia para acceder a los datos del resto de la aplicación
class NoteRepository(private val notesDao: NotesDao) {
    // Creo una variable per a la nostra llista per a rebre totes les notes de la classe DAO.
    val allNotes: LiveData<List<Note>> = notesDao.getAllNotes()

    //Funció per a insertar notes que truca a la funció de insertar a la bdd
    suspend fun insert(note: Note) {
        notesDao.insert(note)
    }

    //Funció per a borrar notes que truca a la funció de borrar a la bdd
    suspend fun delete(note: Note){
        notesDao.delete(note)
    }

    //Funció per a actualitzar notes que truca a la funció de actualitzar a la bdd
    suspend fun update(note: Note){
        notesDao.update(note)
    }
}