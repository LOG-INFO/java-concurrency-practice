package info.log.kotlincoroutineapi.web

import kotlinx.coroutines.reactive.awaitSingle
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.Duration.ofMillis


@RestController
class HelloController {
    @GetMapping("/hello")
    suspend fun hello(): Long {
        return Mono.delay(ofMillis(100))
            .awaitSingle()
    }
}