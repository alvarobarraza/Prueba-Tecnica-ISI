package com.example.pruebatecnica_isimo.ui.fourthPoint

import Character
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica_isimo.data.ApiRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class FourthPointViewModel(private val repository: ApiRepository): ViewModel(){

    private val _characters = MutableLiveData<List<Character>>()
    val characters: LiveData<List<Character>> get() = _characters

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun fetchCharactersInParallel() {

        viewModelScope.launch {
            try {

                _isLoading.value = true

                val characters1 = repository.fetchCharacters("api/character/?page=1").results
                val characters5 = repository.fetchCharacters("api/character/?page=5").results
                val characters9 = repository.fetchCharacters("api/character/?page=9").results

                _characters.value = characters1 + characters5 + characters9

            }catch (e:Exception){
                Log.e("FourthPointFragment", "Error fetching characters", e)
            } finally {
                _isLoading.value = false
            }
        }
    }

}