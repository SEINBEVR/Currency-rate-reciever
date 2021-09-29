package ru.kirill.vasilev.exchangerates.controllerTest

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get


@SpringBootTest
@AutoConfigureMockMvc
class ExchangeControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `get response`() {
        mockMvc.get("/api/gif/EUR")
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.IMAGE_GIF) }
            }
    }

    @Test
    fun `invalid currency code`() {
        mockMvc.get("/api/gif/invalidCode")
            .andExpect {
                status { isForbidden() }
            }
    }
}