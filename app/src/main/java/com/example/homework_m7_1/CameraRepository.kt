package com.example.homework_m7_1

import androidx.lifecycle.LiveData
import androidx.room.Dao
import com.example.homework_m7_1.data.Camera
import com.example.homework_m7_1.data.CameraDao
import com.example.homework_m7_1.data.api.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CameraRepository(private val cameraDao: CameraDao) {
    private val apiService = ApiClient.apiService

    val cameras: LiveData<List<Camera>> = cameraDao.fetchAllCameras()

    suspend fun fetchCamerasFromApi() {
        withContext(Dispatchers.IO) {
            try {
                val camerasFromApi = apiService.getCamera()
                cameraDao.clearCameras()
                camerasFromApi.forEach { cameraDao.insertCamera(it) }
            } catch (e: Exception) {
                // Handle the error
            }
        }
    }
}