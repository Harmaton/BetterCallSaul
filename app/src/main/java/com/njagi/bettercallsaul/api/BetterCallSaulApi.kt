package com.njagi.bettercallsaul.api


import com.njagi.bettercallsaul.data.Characters
import com.njagi.bettercallsaul.utils.CONSTANTS.CHARACTER_ENDPOINTS
import retrofit2.http.GET

interface BetterCallSaulApi {

   @GET(CHARACTER_ENDPOINTS)
   suspend fun getCharacters() : Characters

}