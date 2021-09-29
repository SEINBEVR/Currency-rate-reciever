package ru.kirill.vasilev.exchangerates.services

import org.springframework.http.ResponseEntity
import ru.kirill.vasilev.exchangerates.dto.GiphyDTO

interface GiphyService {
    fun getGif(tag: String): ResponseEntity<GiphyDTO>
}