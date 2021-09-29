package ru.kirill.vasilev.exchangerates.services.implementation

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.kirill.vasilev.exchangerates.clients.DownloadGifClient
import ru.kirill.vasilev.exchangerates.services.DownloadGifService
import java.net.URI

@Service
class DownloadGifServiceImpl(val downloadGifClient: DownloadGifClient): DownloadGifService {

    override fun getGifByURL(url: URI): ResponseEntity<ByteArray> {
        return downloadGifClient.getGifByURL(url)
    }

}