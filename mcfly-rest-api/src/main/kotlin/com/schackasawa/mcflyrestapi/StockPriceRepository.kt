package com.schackasawa.mcflyrestapi

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface StockPriceRepository : JpaRepository<StockPrice, Long> {
    fun findByStockId(stockId: Long): Optional<StockPrice>
}
