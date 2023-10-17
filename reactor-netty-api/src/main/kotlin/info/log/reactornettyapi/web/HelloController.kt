package info.log.reactornettyapi.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.Duration.ofMillis


@RestController
class HelloController {

    @GetMapping("/hello")
    fun hello(): Mono<Long> {
        return Mono.delay(ofMillis(100))
    }
}