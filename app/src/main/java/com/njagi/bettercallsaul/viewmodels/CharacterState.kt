package com.njagi.bettercallsaul.viewmodels

import com.njagi.bettercallsaul.data.Character

sealed class CharacterState {
    object Empty : CharacterState()
    object Loading : CharacterState()
    class Success(val data: List<Character>) : CharacterState()
    class Error(val message: String) : CharacterState()
}
