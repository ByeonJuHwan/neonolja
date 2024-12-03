package com.dev.search.adapter.web.v1.out.persistance

import com.dev.hotel.application.port.out.SearchHotelPort
import com.dev.hotel.domain.Hotel
import org.springframework.stereotype.Component

@Component
class HotelPersistenceAdapter (
    private val hotelRepository: SpringDataHotelRepository,
) : SearchHotelPort {
    override fun findByLocation(location: String) : List<Hotel> {
        return hotelRepository.findHotelByLocation(location)
    }
}