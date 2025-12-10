package com.example.module06demo03

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Music(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val title: String,
    val author: String,
    @ColumnInfo(name = "duration")
    val durationInSeconds: Int
)