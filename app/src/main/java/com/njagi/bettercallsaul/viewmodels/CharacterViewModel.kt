package com.njagi.bettercallsaul.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.njagi.bettercallsaul.data.Character
import com.njagi.bettercallsaul.data.CharacterResponse
import com.njagi.bettercallsaul.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private  val CharacterRepository: CharacterRepository)  : ViewModel() {
    private val _charactersState = MutableStateFlow<CharacterState>(CharacterState.Empty)
    val characterstate : StateFlow<CharacterState> = _charactersState

    init {
        getAllCharacterStates()
    }

    private fun getAllCharacterStates() {
        _charactersState.value = CharacterState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val characterResponse = CharacterRepository.getAllCharacters()
                _charactersState.value = CharacterState.Success(characterResponse)

            }catch (exception : HttpException){
                _charactersState.value = CharacterState.Error("No Internet connection buddy")
            }catch (exception : IOException){
                _charactersState.value = CharacterState.Error("Something went wrong")
            }
        }
    }


}