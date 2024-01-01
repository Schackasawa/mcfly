package com.schackasawa.mcflyrestapi

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StockRepository : JpaRepository<Stock, Long> {
    fun findByTicker(ticker: String): Optional<Stock>
}
