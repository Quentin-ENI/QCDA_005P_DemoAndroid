package com.example.module06demo03

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MusicDAO {
    @Insert
    suspend fun insert(music: Music): Long

    @Query("SELECT * FROM music")
    fun findAll(): List<Music>

    @Query("SELECT * FROM music WHERE id = :id")
    fun findById(id: Long): Music
}