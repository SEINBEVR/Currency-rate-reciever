package ru.kirill.vasilev.exchangerates.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

/**
 * Configuration for connection with giphy REST API
 */
@ConstructorBinding
@ConfigurationProperties("giphy")
data class GiphyConfig(
    val api_key: String,
    val url: String
)
