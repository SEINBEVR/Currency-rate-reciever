package ru.kirill.vasilev.exchangerates.serviceTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.kirill.vasilev.exchangerates.services.OpenexchangeratesService
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@SpringBootTest
class OpenexchangeratesTest {

    @Autowired
    private lateinit var openexchangeratesService: OpenexchangeratesService

    @Test
    fun `get currency`() {
        val date = LocalDate.now().format(DateTimeFormatter.ISO_DATE)
        val responseEntity = openexchangeratesService.getCurrency(date, "RUB,EUR")
        assertAll(
            { assertEquals(responseEntity.statusCodeValue, 200) },
            { assertNotNull(responseEntity.body) },
            { assertNotNull(responseEntity.body!!.rates["RUB"]) },
            { assertNotNull(responseEntity.body!!.rates["EUR"]) }
        )
    }
}