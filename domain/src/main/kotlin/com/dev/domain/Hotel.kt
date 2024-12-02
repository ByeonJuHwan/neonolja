package com.dev.domain

class Hotel private constructor(
    val hotelId: Long,
    val hotelName: String,
    val hotelDescription: String,
    val location: String,
)