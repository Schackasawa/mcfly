package com.schackasawa.mcflyrestapi

import org.springframework.stereotype.Service
import java.util.*

@Service
class StockPriceService(private val stockPriceRepository: StockPriceRepository) {

    fun getAllEntities() = stockPriceRepository.findAll()
    fun getEntityByStockId(stockId: Long): Optional<StockPrice> = stockPriceRepository.findByStockId(stockId)
    fun createEntity(entity: StockPrice): StockPrice = stockPriceRepository.save(entity)
}
