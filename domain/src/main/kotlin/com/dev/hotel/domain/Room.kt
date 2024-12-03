package com.dev.hotel.domain

class Room private constructor(
    val roomId: String,
    val roomName: String,
    val roomDescription: String,
    val roomOptions: List<RoomOption>,
) {
    data class RoomId(
        val roomId: String,
    )
    data class RoomName(
        val roomName: String,
    )
    data class RoomDescription(
        val roomDescription: String,
    )

    data class RoomOptions(
        val roomOptions: List<RoomOption>,
    )

    companion object {
        fun generateRoom(
            roomId: RoomId,
            roomName: RoomName,
            roomDescription: RoomDescription,
            roomOptions: RoomOptions,
        ): Room {
            return Room(
                roomId.roomId,
                roomName.roomName,
                roomDescription.roomDescription,
                roomOptions.roomOptions,
            )
        }
    }
}