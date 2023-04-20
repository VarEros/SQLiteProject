package com.example.sqliteproject.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblPersona")
data class Person(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idPersona") val id: Int,
    @ColumnInfo(name = "nombre") val name: String,
    @ColumnInfo(name = "apellido") val lastname: String,
    @ColumnInfo(name = "edad") val age: Int,
    @ColumnInfo(name = "edad") val email: String
) {
    fun generarEmail (): String {
        return "${name.lowercase()} ${lastname.lowercase()} ${age} @uca.edu.ni"
    }
}
