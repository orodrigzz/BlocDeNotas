package com.blocdenotes.oscarrodriguez

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNotesDao(): NotesDao

    //Creem la bdd note_database
    companion object {
        @Volatile
        // Singleton
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            // si la INSTANCIA no es nula, la retorna,
            // si es nula, crea la badd
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()
                INSTANCE = instance
                // retorna la instancia
                instance
            }
        }
    }


}