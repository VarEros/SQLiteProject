package com.example.sqliteproject.dao

import androidx.room.*
import com.example.sqliteproject.entities.Person

@Dao
interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPerson(person: Person)

    @Update
    fun updatePerson(person: Person)

    @Delete
    fun deletePerson(person: Person)

    @Query("SELECT * FROM tblPersona WHERE id: id")
    fun getPersonFromId(id: Int): Person

    @Query("SELECT * FROM tblPersona")
    fun getPersons(): List<Person>
}