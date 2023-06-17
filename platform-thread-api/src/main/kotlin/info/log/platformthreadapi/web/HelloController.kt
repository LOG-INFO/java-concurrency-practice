package info.log.platformthreadapi.web

import info.log.domain.Person
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {
    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @GetMapping("/hello")
    fun hello(): List<Person> {
        return Person.createPeopleListRandomly()
    }
}