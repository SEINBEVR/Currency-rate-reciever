package ru.kirill.vasilev.exchangerates.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal
import java.time.LocalDate

data class OpenexchangeratesDTO(
    @JsonProperty(value = "disclaimer")
    val disclaimer: String,
    @JsonProperty(value = "license")
    val license: String,
    @JsonProperty(value = "timestamp")
    val timestamp: LocalDate,
    @JsonProperty(value = "base")
    val base: String,
    @JsonProperty(value = "rates")
    val rates: HashMap<String, BigDecimal>
)
