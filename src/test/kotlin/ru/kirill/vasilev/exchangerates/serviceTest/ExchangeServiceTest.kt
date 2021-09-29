package ru.kirill.vasilev.exchangerates.serviceTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.kirill.vasilev.exchangerates.exception.BadCurrencyToExchange
import ru.kirill.vasilev.exchangerates.services.ExchangeService

@SpringBootTest
class ExchangeServiceTest {

    @Autowired
    private lateinit var exchangeService: ExchangeService

    @Test
    fun `bad currency to exchange exception test`() {
        val badCurrencyToExchangeMessage = "Код валюты должен состоять из 3х символов"
        val exception = org.junit.jupiter.api.assertThrows<BadCurrencyToExchange>("Ожидаемая ошибка: неверный код валюты") {
            exchangeService.getGifByExchangeRate("BADCURRENCYCODE")
        }
        assertTrue(exception.message!!.contains(badCurrencyToExchangeMessage))
    }
}