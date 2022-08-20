package com.njagi.bettercallsaul.repository

import com.njagi.bettercallsaul.api.BetterCallSaulApi
import com.njagi.bettercallsaul.data.CharacterItem
import javax.inject.Inject

class CharacterRepository @Inject constructor(private  val saulApi: BetterCallSaulApi) {
    suspend fun getAllCharacters() : ArrayList<CharacterItem> = saulApi.getCharacters().data
}