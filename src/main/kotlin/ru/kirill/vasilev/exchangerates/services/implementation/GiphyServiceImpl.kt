package ru.kirill.vasilev.exchangerates.services.implementation

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.kirill.vasilev.exchangerates.clients.GiphyClient
import ru.kirill.vasilev.exchangerates.configuration.GiphyConfig
import ru.kirill.vasilev.exchangerates.dto.GiphyDTO
import ru.kirill.vasilev.exchangerates.services.GiphyService

/**
 * Service for receiving DTO of the gif received by a tag using giphyClient
 */
@Service
class GiphyServiceImpl(val giphyClient: GiphyClient,
                       val giphyConfig: GiphyConfig): GiphyService {

    override fun getGif(tag: String): ResponseEntity<GiphyDTO> {
       return giphyClient.getGif(giphyConfig.api_key, tag)
    }

}