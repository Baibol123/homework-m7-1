package com.example.homework_m7_1.fragment.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.homework_m7_1.DoorRepository
import com.example.homework_m7_1.data.DoorDao

class DoorViewModelFactory(private val doorDao: DoorDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DoorViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DoorViewModel(DoorRepository(doorDao)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}