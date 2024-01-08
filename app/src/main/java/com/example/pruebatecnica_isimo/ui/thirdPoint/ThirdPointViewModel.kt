package com.example.pruebatecnica_isimo.ui.thirdPoint

import androidx.lifecycle.ViewModel
import com.example.pruebatecnica_isimo.data.UserRepository
import com.example.pruebatecnica_isimo.model.User

class ThirdPointViewModel: ViewModel() {

    private val userRepository = UserRepository()

    fun getUserList(): List<User> {
        return userRepository.getUserList()
    }

}