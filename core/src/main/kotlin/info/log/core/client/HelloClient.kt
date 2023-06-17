package info.log.core.client

import info.log.domain.Person
import org.springframework.web.service.annotation.GetExchange
import reactor.core.publisher.Mono

interface HelloClient {
    @GetExchange("/hello")
    fun hello(): Mono<List<Person>>
}