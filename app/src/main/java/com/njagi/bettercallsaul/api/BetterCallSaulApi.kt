package com.njagi.bettercallsaul.api

import com.njagi.bettercallsaul.data.CharacterResponse
import com.njagi.bettercallsaul.data.QuoteResponse
import com.njagi.bettercallsaul.utils.CONSTANTS.CHARACTER_ENDPOINTS
import com.njagi.bettercallsaul.utils.CONSTANTS.SAUL_QUOTES
import retrofit2.http.GET

interface BetterCallSaulApi {

   @GET(CHARACTER_ENDPOINTS)
   suspend fun getCharacters() : CharacterResponse

   @GET(SAUL_QUOTES)
   suspend fun getQuotes(): QuoteResponse
}