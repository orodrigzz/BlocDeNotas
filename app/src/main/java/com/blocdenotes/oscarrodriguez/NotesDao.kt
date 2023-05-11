package com.blocdenotes.oscarrodriguez

import androidx.lifecycle.LiveData
import androidx.room.*

//DAO es un objeto de acceso a datos que se utiliza para especificar consultas SQL y luego asociarlas con diferentes llamadas a métodos.
//Dentro de la clase DAO, tenemos que crear diferentes métodos, como insertar, eliminar los datos y leer los datos de nuestra base de datos.
// Entonces, esta clase básicamente interactuará con nuestra base de datos para agregar o eliminar datos dentro de nuestra base de datos.
@Dao
interface NotesDao {
    //Funció per a insertar a la bdd
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note :Note)

    //Funció per a actualitzar a la bdd
    @Update
    suspend fun update(note: Note)

    //Funció per a borrar a la bdd
    @Delete
    suspend fun delete(note: Note)

    //Funció per seleccionar a la bdd
    @Query("Select * from notesTable order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>


}