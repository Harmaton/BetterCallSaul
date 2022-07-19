package com.njagi.bettercallsaul.repository

import com.njagi.bettercallsaul.api.BetterCallSaulApi
import com.njagi.bettercallsaul.data.Character
import com.njagi.bettercallsaul.data.CharacterResponse
import javax.inject.Inject

class CharacterRepository @Inject constructor(private  val betterCallSaulApi: BetterCallSaulApi) {
    suspend fun getAllCharacters() : List<Character> = betterCallSaulApi.getCharacters().data
}