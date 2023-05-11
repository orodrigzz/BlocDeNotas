package com.blocdenotes.oscarrodriguez

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity ROOM:
//Cuando usas la biblioteca de Room para almacenar los datos de tu app, defines entidades para representar los objetos que deseas almacenar.
// Cada entidad corresponde a una tabla en la base de datos de Room asociada y cada instancia de una entidad representa una fila de datos en la tabla correspondiente.
//Puedes usar las entidades de Room para definir tu esquema de base de datos sin escribir ningún código de SQL.
//Room usa el nombre de la clase como el nombre de la tabla de la base de datos.
//Si quieres que la tabla tenga un nombre diferente, configura la propiedad tableName de la anotación @Entity

//Especifiquem el nom de la taula
@Entity(tableName = "notesTable")
class Note (
            //Tindrà les columnes title (titol de la nota, string), description(descripció, string) i timestamp(la data, string) a més de la primary key autogenerada
            @ColumnInfo(name = "title")  val noteTitle :String,
            @ColumnInfo(name = "description")val noteDescription :String,
            @ColumnInfo(name = "timestamp")val timeStamp :String) {
            @PrimaryKey(autoGenerate = true) var id = 0
}