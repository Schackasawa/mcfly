package com.schackasawa.mcflyrestapi

import org.springframework.stereotype.Service
import java.util.*

@Service
class StockService(private val stockRepository: StockRepository) {

    fun getAllEntities() = stockRepository.findAll()
    fun getEntityById(id: Long): Optional<Stock> = stockRepository.findById(id)
    fun getEntityByTicker(ticker: String): Optional<Stock> {
        return stockRepository.findByTicker(ticker)
    }
    fun createEntity(entity: Stock): Stock = stockRepository.save(entity)
}
