package com.dev.search.adapter.web.v1.out.persistance

import com.dev.search.adapter.web.v1.out.persistance.query.SpringDataHotelQueryRepository
import com.dev.search.adapter.web.v1.out.persistance.entity.HotelEntity
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataHotelRepository : JpaRepository<HotelEntity, Long>, SpringDataHotelQueryRepository {
}