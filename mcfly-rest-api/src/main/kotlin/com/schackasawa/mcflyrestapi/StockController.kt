package com.schackasawa.mcflyrestapi

import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/stocks")
class StockModelController(private val stockService: StockService, private val stockPriceService: StockPriceService) {

    @GetMapping("/", "")
    fun getAllEntities() = stockService.getAllEntities()

    @GetMapping("/{ticker}")
    fun getStockByTicker(
        @PathVariable ticker: String
    ): Optional<Stock> {
        val upper = ticker.uppercase()
        return stockService.getEntityByTicker(upper)
    }

    @GetMapping("/{ticker}/prices")
    fun getStockPricesByTicker(
        @PathVariable ticker: String
    ): Optional<StockPrice> {
        val upper = ticker.uppercase()
        val optionalStock: Optional<Stock> = stockService.getEntityByTicker(upper)
        var price: Optional<StockPrice> = Optional.ofNullable(null)

        optionalStock.ifPresent { stock ->
            if (stock.id != null)
            {
                price  = stockPriceService.getEntityByStockId(stock.id)
            }
        }
        return price
    }

    @PostMapping
    fun createEntity(@RequestBody entity: Stock) = stockService.createEntity(entity)
}
