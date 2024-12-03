package com.dev.search.adapter.web.v1.out.persistance.entity

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "room_option")
class RoomOptionEntity (

    @Enumerated(EnumType.STRING)
    var roomType: RoomType,
    var startDateTime: LocalDateTime,
    var endDateTime: LocalDateTime,
    var price: BigDecimal,

    @Column(name = "room_id")
    var roomId: Long,

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val roomOptionId: Long? = null,
) {
}