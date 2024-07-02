package com.example.homework_m7_1

import androidx.lifecycle.LiveData
import com.example.homework_m7_1.data.Camera
import com.example.homework_m7_1.data.CameraDao
import com.example.homework_m7_1.data.Door
import com.example.homework_m7_1.data.DoorDao
import com.example.homework_m7_1.data.api.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class DoorRepository(private val doorDao: DoorDao) {
    private val apiService = ApiClient.apiService
    val doors: LiveData<List<Door>> = doorDao.fetchAllDoors()

    suspend fun fetchCamerasFromApi() {
        withContext(Dispatchers.IO) {
            try {
                val doorsFromApi = apiService.getDoor()
                doorDao.clearDoors()
                doorsFromApi.forEach { doorDao.insertDoor(it) }
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }
}