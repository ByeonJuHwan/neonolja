package com.dev.search.adapter.web.v1.`in`.response

import com.dev.hotel.domain.Hotel
import com.dev.hotel.domain.Room
import com.dev.hotel.domain.RoomOption

data class HotelResponse(
    val hotelId: String,
    val hotelName: String,
    val hotelDescription: String,
    val location: String,
    val rooms: List<RoomResponse>
) {
    companion object {
        fun from(hotel: Hotel) = HotelResponse(
            hotelId = hotel.hotelId,
            hotelName = hotel.hotelName,
            hotelDescription = hotel.hotelDescription,
            location = hotel.location,
            rooms = hotel.rooms.map { RoomResponse.from(it) }
        )
    }
}

data class RoomResponse(
    val roomId: String,
    val roomName: String,
    val roomDescription: String,
    val roomOptions: List<RoomOptionResponse>
) {
    companion object {
        fun from(room: Room) = RoomResponse(
            roomId = room.roomId,
            roomName = room.roomName,
            roomDescription = room.roomDescription,
            roomOptions = room.roomOptions.map { RoomOptionResponse.from(it) },
        )
    }
}

data class RoomOptionResponse(
    val roomOptionId: String,
    val startDate: String,
    val endDate: String,
    val roomType: String,
    val price: String,
) {
    companion object {
            fun from(roomOption: RoomOption) = RoomOptionResponse(
                roomOptionId = roomOption.roomOptionId,
                startDate = roomOption.startDate,
                endDate = roomOption.endDate,
                roomType = roomOption.roomType,
                price = roomOption.price,
            )
        }
}