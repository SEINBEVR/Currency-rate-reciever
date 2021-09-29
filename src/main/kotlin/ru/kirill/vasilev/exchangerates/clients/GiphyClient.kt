package ru.kirill.vasilev.exchangerates.clients

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import ru.kirill.vasilev.exchangerates.dto.GiphyDTO

@FeignClient(url = "\${giphy.url}", name = "gif-client")
interface GiphyClient {

    @GetMapping("/random")
    fun getGif(@RequestParam api_key: String,
               @RequestParam tag: String): ResponseEntity<GiphyDTO>

}