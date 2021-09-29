package ru.kirill.vasilev.exchangerates.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding


@ConstructorBinding
@ConfigurationProperties("giphy")
data class GiphyConfig(
    val api_key: String,
    val url: String
)
