package com.dev.search.application.service

import com.dev.hotel.application.port.`in`.SearchHotelUseCase
import com.dev.hotel.application.port.out.SearchHotelPort
import com.dev.hotel.domain.Hotel
import org.springframework.stereotype.Service

@Service
class SearchHotelService (
    private val searchHotelPort: SearchHotelPort,
) : SearchHotelUseCase {
    override fun searchHotels(location: String) : List<Hotel> {
        return searchHotelPort.findByLocation(location)
    }
}