package ru.kirill.vasilev.exchangerates.exception

class BadCurrencyToExchange(override val message: String?): RuntimeException(message)

