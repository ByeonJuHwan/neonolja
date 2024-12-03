package com.dev.hotel.application.port.out

import com.dev.hotel.domain.Hotel

interface SearchHotelPort {
    fun findByLocation(location: String): List<Hotel>
}