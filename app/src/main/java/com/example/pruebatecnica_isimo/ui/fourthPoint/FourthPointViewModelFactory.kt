package com.example.pruebatecnica_isimo.ui.fourthPoint

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pruebatecnica_isimo.data.ApiRepository

class FourthPointViewModelFactory(private val repository: ApiRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FourthPointViewModel::class.java)) {
            return FourthPointViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
