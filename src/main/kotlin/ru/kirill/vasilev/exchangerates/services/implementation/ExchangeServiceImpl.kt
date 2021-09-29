package ru.kirill.vasilev.exchangerates.services.implementation

import io.klogging.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.kirill.vasilev.exchangerates.exception.BadCurrencyToExchange
import ru.kirill.vasilev.exchangerates.services.DownloadGifService
import ru.kirill.vasilev.exchangerates.services.ExchangeService
import ru.kirill.vasilev.exchangerates.services.GiphyService
import ru.kirill.vasilev.exchangerates.services.OpenexchangeratesService
import java.math.BigDecimal
import java.net.URI
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Service
class ExchangeServiceImpl(val downloadGifService: DownloadGifService,
                          val giphyService: GiphyService,
                          val openexchangeratesService: OpenexchangeratesService): ExchangeService {

    val logger = noCoLogger(ExchangeServiceImpl::class)

    override fun getGifByExchangeRate(currencyToExchange: String): ResponseEntity<ByteArray> {
        logger.info("Начало поиска gif по извлеченному курсу")
        val today = LocalDate.now().format(DateTimeFormatter.ISO_DATE)
        val yesterday = LocalDate.now().minusDays(1).format(DateTimeFormatter.ISO_DATE)
        if(!isCurrencyValid(currencyToExchange)) {
            logger.info("В настройках задан неверный код валюты")
            throw BadCurrencyToExchange("Код валюты должен состоять из 3х символов")
        }
        logger.info("Код валюты для обмена $currencyToExchange")
        val symbols = "RUB,${currencyToExchange.uppercase()}"
        val rateToday = getRateByDateAndSymbols(today, symbols, currencyToExchange)
        val rateYesterday = getRateByDateAndSymbols(yesterday, symbols, currencyToExchange)
        val tag = getRichOrBroke(rateToday, rateYesterday)
        logger.info("По итогам изменения курса будет получен gif из категории: $tag")
        val gifURI = URI.create(getGifByTag(tag))
        return downloadGifService.getGifByURI(gifURI)
    }

    private fun isCurrencyValid(symbols: String?) =
        symbols?.length == 3


    private fun getRateByDateAndSymbols(date: String, symbols: String, currencyToExchange: String): BigDecimal {
        val currencyDTO = openexchangeratesService.getCurrency(date, symbols).body
        val rate = currencyDTO!!.rates["RUB"]!!.div(currencyDTO.rates[currencyToExchange]!!)
        logger.info("Курс на момент $date составляет $rate")
        return rate
    }

    private fun getRichOrBroke(rateToday: BigDecimal, rateYesterday: BigDecimal): String {
        return if(rateToday > rateYesterday) "rich"
        else "broke"
    }

    private fun getGifByTag(tag: String): String {
        val gifDTO = giphyService.getGif(tag).body
        val gifURL = gifDTO!!.data["image_original_url"].toString()
        logger.info("URL полученного gif $gifURL")
        return gifURL
    }

}