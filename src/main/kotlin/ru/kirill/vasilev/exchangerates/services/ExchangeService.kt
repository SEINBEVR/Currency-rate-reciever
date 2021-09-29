package ru.kirill.vasilev.exchangerates.services

import org.springframework.http.ResponseEntity

interface ExchangeService {
    fun getGifByExchangeRate(currencyToExchange: String): ResponseEntity<ByteArray>
}