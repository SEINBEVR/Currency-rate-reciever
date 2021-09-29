package ru.kirill.vasilev.exchangerates.clients


import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import ru.kirill.vasilev.exchangerates.dto.OpenexchangeratesDTO


@FeignClient(url = "\${openexchangerates.url}", name = "openexchangerates-client")
interface OpenexchangeratesClient {

    @GetMapping("{date}.json")
    fun getCurrency(@PathVariable("date") date: String,
                      @RequestParam app_id: String,
                      @RequestParam base: String = "USD",
                      @RequestParam symbols: String): ResponseEntity<OpenexchangeratesDTO>
}