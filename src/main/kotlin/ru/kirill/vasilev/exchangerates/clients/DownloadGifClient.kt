package ru.kirill.vasilev.exchangerates.clients

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import java.net.URI

@FeignClient(url = "https://placeholder", name = "downloadgif-client")
interface DownloadGifClient {

    @GetMapping
    fun getGifByURI(uri: URI): ResponseEntity<ByteArray>
}