package com.dev.hotel.application.port.`in`

import com.dev.hotel.domain.Hotel

interface SearchHotelUseCase {
    fun searchHotels(location: String): List<Hotel>
}