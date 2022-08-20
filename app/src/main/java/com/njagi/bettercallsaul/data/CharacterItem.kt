package com.njagi.bettercallsaul.data


import com.squareup.moshi.Json


data class CharacterItem(
    @Json(name = "appearance")
    val appearance: List<Int>,
    @Json(name = "birthday")
    val birthday: String,
    @Json(name = "char_id")
    val charId: Int,
    @Json(name = "img")
    val img: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "nickname")
    val nickname: String,
    @Json(name = "occupation")
    val occupation: List<String>,
    @Json(name = "portrayed")
    val portrayed: String,
    @Json(name = "status")
    val status: String
)