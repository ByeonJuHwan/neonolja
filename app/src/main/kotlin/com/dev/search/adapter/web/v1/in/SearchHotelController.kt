package com.dev.search.adapter.web.v1.`in`

import com.dev.hotel.application.port.`in`.SearchHotelUseCase
import com.dev.search.adapter.web.v1.`in`.request.SearchRequest.*
import com.dev.search.adapter.web.v1.`in`.response.HotelResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/hotels")
class SearchHotelController (
    private val searchHotelUseCase: SearchHotelUseCase
) {

    @GetMapping("/search")
    fun searchHotels(request: HotelSearchRequest) : List<HotelResponse> {
        return searchHotelUseCase.searchHotels(request.location).map { HotelResponse.from(it) }
    }
}