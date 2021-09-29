package ru.kirill.vasilev.exchangerates.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class GiphyDTO(
    @JsonProperty(value = "data")
    val data: Map<String, Any>
)
