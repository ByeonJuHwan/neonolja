package com.dev.search.adapter.web.v1.out.persistance.query

import com.dev.hotel.domain.Hotel


interface SpringDataHotelQueryRepository {
    fun findHotelByLocation(location: String): List<Hotel>
}