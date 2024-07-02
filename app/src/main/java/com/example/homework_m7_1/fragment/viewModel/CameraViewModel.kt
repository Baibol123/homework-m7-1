package com.example.homework_m7_1.fragment.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_m7_1.data.Camera
import com.example.homework_m7_1.CameraRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class CameraViewModel(private val repository: CameraRepository) : ViewModel() {
    val cameras = repository.cameras

    fun refreshCameras() {
        viewModelScope.launch {
            repository.fetchCamerasFromApi()
        }
    }

}