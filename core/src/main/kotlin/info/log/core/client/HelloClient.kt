package info.log.core.client

import org.springframework.web.service.annotation.GetExchange

interface HelloClient {
    @GetExchange("/hello")
    fun hello()
}