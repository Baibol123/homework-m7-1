package com.example.homework_m7_1.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface CameraDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCamera(camera: Camera)

    @Query("SELECT * FROM cameras")
    fun fetchAllCameras(): LiveData<List<Camera>>

    @Query("DELETE FROM cameras")
    suspend fun clearCameras()
}
@Dao
interface DoorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDoor(door: Door)

    @Query("SELECT * FROM doors")
     fun fetchAllDoors(): LiveData<List<Door>>

    @Query("DELETE FROM doors")
    suspend fun clearDoors()
}