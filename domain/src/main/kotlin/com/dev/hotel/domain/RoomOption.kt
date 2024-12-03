package com.dev.hotel.domain

class RoomOption private constructor(
    val roomOptionId: String,
    val startDate: String,
    val endDate: String,
    val roomType: String,
    val price: String,
) {
    data class RoomOptionId(
        val roomOptionId: String,
    )
    data class StartDate(
        val startDate: String,
    )
    data class EndDate(
        val endDate: String,
    )
    data class RoomType(
        val roomType: String,
    )
    data class Price(
        val price: String,
    )

    companion object {
        fun generateRoomOption(
            roomOptionId: RoomOptionId,
            startDate: StartDate,
            endDate: EndDate,
            roomType: RoomType,
            price: Price,
        ): RoomOption {
            return RoomOption(
                roomOptionId.roomOptionId,
                startDate.startDate,
                endDate.endDate,
                roomType.roomType,
                price.price,
            )
        }
    }
}