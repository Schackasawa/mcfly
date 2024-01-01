package com.schackasawa.mcflyrestapi

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table;
import java.sql.Date

@Entity
@Table(name = "stock_prices")
data class StockPrice(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val stock_id: Long? = null,
    val date: Date? = null,
    val open: Float? = null,
    val close: Float? = null,
    val high: Float? = null,
    val low: Float? = null
)
