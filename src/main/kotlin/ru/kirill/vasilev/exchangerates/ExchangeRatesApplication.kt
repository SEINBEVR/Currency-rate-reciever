package ru.kirill.vasilev.exchangerates

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import ru.kirill.vasilev.exchangerates.configuration.GiphyConfig
import ru.kirill.vasilev.exchangerates.configuration.OpenexchangeConfig

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(OpenexchangeConfig::class, GiphyConfig::class)
class ExchangeRatesApplication

fun main(args: Array<String>) {
    runApplication<ExchangeRatesApplication>(*args)

}
