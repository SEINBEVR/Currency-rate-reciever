package ru.kirill.vasilev.exchangerates.clients

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import java.net.URI

/**
 * Feign client for the connection with placeholder for gif
 */
@FeignClient(url = "https://placeholder", name = "downloadgif-client")
interface DownloadGifClient {

    @GetMapping
    fun getGifByURI(uri: URI): ResponseEntity<ByteArray>
}