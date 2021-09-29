package ru.kirill.vasilev.exchangerates.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.kirill.vasilev.exchangerates.services.ExchangeService


@RestController
@RequestMapping("/api")
class ExchangeController(val exchangeService: ExchangeService) {

    @GetMapping("/gif/{currencyToExchange}")
    fun getGifByRate(@PathVariable currencyToExchange: String): ResponseEntity<ByteArray> {
        return exchangeService.getGifByExchangeRate(currencyToExchange)
    }

}