package com.example.homework_m7_1.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "cameras")
data class Camera(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val snapshot: String,
    val room: String
)
@Entity(tableName = "doors")
data class Door(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val room: String,
    val snapshot: String
)
