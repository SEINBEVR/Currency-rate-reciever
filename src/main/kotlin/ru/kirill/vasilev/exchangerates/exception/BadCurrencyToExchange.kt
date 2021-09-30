package ru.kirill.vasilev.exchangerates.exception

/**
 * Exception which occurs while using not valid currency code in symbols to get the exchange rate
 */
class BadCurrencyToExchange(override val message: String?): RuntimeException(message)

