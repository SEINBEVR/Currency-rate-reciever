package ru.kirill.vasilev.exchangerates.services

import org.springframework.http.ResponseEntity
import java.net.URI

interface DownloadGifService {
    fun getGifByURL(url: URI): ResponseEntity<ByteArray>
}