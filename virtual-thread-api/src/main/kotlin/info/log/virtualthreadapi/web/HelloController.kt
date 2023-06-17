package info.log.virtualthreadapi.web

import info.log.domain.Person
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello(): List<Person> {
        return Person.createPeopleListRandomly()
    }
}