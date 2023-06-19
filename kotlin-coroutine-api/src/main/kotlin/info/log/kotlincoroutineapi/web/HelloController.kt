package info.log.kotlincoroutineapi.web

import info.log.domain.Person
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {
    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/hello")
    suspend fun hello(): Flow<Person> {
        return Person.createPeopleFluxRandomly().asFlow()
    }
}