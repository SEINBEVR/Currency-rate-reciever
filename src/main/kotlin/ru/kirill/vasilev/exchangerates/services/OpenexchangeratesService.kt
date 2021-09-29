package ru.kirill.vasilev.exchangerates.services

import org.springframework.http.ResponseEntity
import ru.kirill.vasilev.exchangerates.dto.OpenexchangeratesDTO

interface OpenexchangeratesService {
    fun getCurrency(date: String, symbols: String): ResponseEntity<OpenexchangeratesDTO>
}