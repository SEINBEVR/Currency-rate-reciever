package ru.kirill.vasilev.exchangerates.exception.handler

import feign.FeignException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import ru.kirill.vasilev.exchangerates.exception.response.Response
import ru.kirill.vasilev.exchangerates.exception.BadCurrencyToExchange

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(FeignException::class)
    fun feignClientException(e: Exception): ResponseEntity<Response> {
        val errorDetails = Response("Ошибка при взаимодействии с внешним API", e.message!!)
        return ResponseEntity(errorDetails, HttpStatus.METHOD_NOT_ALLOWED)
    }

    @ExceptionHandler(BadCurrencyToExchange::class)
    fun badCurrencyException(e: Exception): ResponseEntity<Response> {
        val errorDetails = Response("Неверно указана валюта для сравнения", e.message!!)
        return ResponseEntity(errorDetails, HttpStatus.FORBIDDEN)
    }

    fun anyOtherException(e: Exception): ResponseEntity<Response> {
        val errorDetails = Response("", e.message!!)
        return ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST)
    }

}