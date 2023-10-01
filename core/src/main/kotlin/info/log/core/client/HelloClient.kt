package info.log.core.client

import info.log.domain.Person
import org.springframework.web.service.annotation.GetExchange

interface HelloClient {
    @GetExchange("/hello")
    fun hello(): List<Person>
}