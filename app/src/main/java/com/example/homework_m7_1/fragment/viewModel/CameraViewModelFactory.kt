package com.example.homework_m7_1.fragment.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.homework_m7_1.CameraRepository
import com.example.homework_m7_1.data.CameraDao

class CameraViewModelFactory(private val cameraDao: CameraDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CameraViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CameraViewModel(CameraRepository(cameraDao)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}