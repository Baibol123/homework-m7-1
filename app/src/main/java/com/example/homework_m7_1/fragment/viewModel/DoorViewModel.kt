package com.example.homework_m7_1.fragment.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_m7_1.DoorRepository
import kotlinx.coroutines.launch

class DoorViewModel(private val repository: DoorRepository) : ViewModel() {
    val doors = repository.doors

    fun refreshDoors() {
        viewModelScope.launch {
            repository.fetchCamerasFromApi()
        }
    }
}