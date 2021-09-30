package ru.kirill.vasilev.exchangerates.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.PropertySource

/**
 * Configuration for connection with openexchangerates REST API
 */
@ConstructorBinding
@ConfigurationProperties("openexchangerates")
data class OpenexchangeConfig(
    val api_key: String,
    val url: String,
)
