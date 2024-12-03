package com.dev.search.adapter.web.v1.out.persistance.entity

import jakarta.persistence.*

@Entity
@Table(name = "hotel")
class HotelEntity (
    var hotelName: String,
    var hotelDescription: String,
    var location: String,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val hotelId: Long? = null
) {
}