package com.dev.search.adapter.web.v1.out.persistance.entity

import jakarta.persistence.*

@Entity
@Table(name = "room")
class RoomEntity(
    var roomName: String,
    var roomDescription: String,

    @Column(name = "hotel_id")
    var hotelId: Long,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val roomId: Long? = null,
) {
}