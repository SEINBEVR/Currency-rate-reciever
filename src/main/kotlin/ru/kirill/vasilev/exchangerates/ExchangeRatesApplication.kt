package ru.kirill.vasilev.exchangerates

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import ru.kirill.vasilev.exchangerates.configuration.GiphyConfig
import ru.kirill.vasilev.exchangerates.configuration.OpenexchangeConfig

/**
 * @author Kirill Vasilev - kirill.vasilev.work@gmail.com
 * The application receives the exchange rate for today and yesterday and,
 * based on comparison results,
 * returns gif from "rich" or "broke" category
 */
@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(OpenexchangeConfig::class, GiphyConfig::class)
class ExchangeRatesApplication

fun main(args: Array<String>) {
    runApplication<ExchangeRatesApplication>(*args)

}
