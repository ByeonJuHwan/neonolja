package com.dev.search.adapter.web.v1.out.persistance.query

import com.dev.hotel.domain.Hotel
import com.dev.hotel.domain.Room
import com.dev.hotel.domain.RoomOption
import com.dev.search.adapter.web.v1.out.persistance.entity.QHotelEntity.hotelEntity
import com.dev.search.adapter.web.v1.out.persistance.entity.QRoomEntity.roomEntity
import com.dev.search.adapter.web.v1.out.persistance.entity.QRoomOptionEntity.roomOptionEntity
import com.querydsl.jpa.impl.JPAQueryFactory

class SpringDataHotelQueryRepositoryImpl(
    private val queryFactory: JPAQueryFactory,
) : SpringDataHotelQueryRepository {

    /**
     * 호텔 목록 검색
     * 1:N:N 검색을 해야함
     * JPA 에서는 2개이상의 컬렌션이 fetch join 이 안되므로
     * 각각 조회해서 합치는 방식으로 진행
     */
    override fun findHotelByLocation(location: String): List<Hotel> {

        val hotels = queryFactory
            .selectFrom(hotelEntity)
            .where(
                hotelEntity.location.eq(location)
            )
            .fetch()

        val hotelIds = hotels.map { it.hotelId }

        val rooms = queryFactory
            .selectFrom(roomEntity)
            .where(roomEntity.hotelId.`in`(hotelIds))
            .fetch()

        val roomIds = rooms.map { it.roomId }

        val roomOptions = queryFactory
            .selectFrom(roomOptionEntity)
            .where(roomOptionEntity.roomId.`in`(roomIds))
            .fetch()

        val roomsByHotelId = rooms.groupBy { it.hotelId }
        val optionsByRoomId = roomOptions.groupBy { it.roomId }

        return hotels.map { hotel ->
            Hotel.generateHotel(
                hotelId = Hotel.HotelId(hotel.hotelId.toString()),
                hotelName = Hotel.HotelName(hotel.hotelName),
                hotelDescription = Hotel.HotelDescription(hotel.hotelDescription),
                location = Hotel.Location(hotel.location),
                rooms = Hotel.Rooms(
                    roomsByHotelId[hotel.hotelId]?.map { room ->
                        Room.generateRoom(
                            roomId = Room.RoomId(room.roomId.toString()),
                            roomName = Room.RoomName(room.roomName),
                            roomDescription = Room.RoomDescription(room.roomDescription),
                            roomOptions = Room.RoomOptions(
                                optionsByRoomId[room.roomId]?.map { option ->
                                    RoomOption.generateRoomOption(
                                        roomOptionId = RoomOption.RoomOptionId(option.roomOptionId.toString()),
                                        startDate = RoomOption.StartDate(option.startDateTime.toString()),
                                        endDate = RoomOption.EndDate(option.endDateTime.toString()),
                                        roomType = RoomOption.RoomType(option.roomType.name),
                                        price = RoomOption.Price(option.price.toString())
                                    )
                                } ?: emptyList()
                            )
                        )
                    } ?: emptyList()
                )
            )
        }
    }
}