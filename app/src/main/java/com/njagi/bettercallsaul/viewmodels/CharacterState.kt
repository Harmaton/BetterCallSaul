package com.njagi.bettercallsaul.viewmodels

import com.njagi.bettercallsaul.data.CharacterItem


sealed class CharacterState {
    object Empty : CharacterState()
    object Loading : CharacterState()
    class Success(val data: ArrayList<CharacterItem>) : CharacterState()
    class Error(val message: String) : CharacterState()
}
