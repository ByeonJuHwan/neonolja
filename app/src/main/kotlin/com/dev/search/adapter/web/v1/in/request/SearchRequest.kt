package com.dev.search.adapter.web.v1.`in`.request

sealed interface SearchRequest {
    data class HotelSearchRequest(
        val location: String,
    )
}