package ru.kirill.vasilev.exchangerates.services.implementation

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.kirill.vasilev.exchangerates.clients.OpenexchangeratesClient
import ru.kirill.vasilev.exchangerates.configuration.OpenexchangeConfig
import ru.kirill.vasilev.exchangerates.dto.OpenexchangeratesDTO
import ru.kirill.vasilev.exchangerates.services.OpenexchangeratesService

@Service
class OpenexchangeratesServiceImpl(val openexchangeratesClient: OpenexchangeratesClient,
                                   val openexchangeConfig: OpenexchangeConfig): OpenexchangeratesService {

    override fun getCurrency(date: String, symbols: String): ResponseEntity<OpenexchangeratesDTO> {
        return openexchangeratesClient.getCurrency(date = date, app_id = openexchangeConfig.api_key, symbols = symbols)
    }

}