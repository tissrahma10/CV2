package com.example.curriculumvitae2

import androidx.room.*

@Dao
interface ExprienceDao {
    @Insert
    fun insert(champ: ExprienceEntity)

    @Update
    fun update(champ: ExprienceEntity)

    @Delete
    fun delete(champ: ExprienceEntity)

    @Query("SELECT * FROM exprience")
    fun getAllChamps(): List<ExprienceEntity>
}