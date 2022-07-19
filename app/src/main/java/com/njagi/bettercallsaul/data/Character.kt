package com.njagi.bettercallsaul.data

data class Character(
    val appearance: List<Int>,
    val birthday: String,
    val char_id: Int,
    val img: String,
    val name: String,
    val nickname: String,
    val occupation: List<String>,
    val portrayed: String,
    val status: String
)