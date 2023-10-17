package info.log.platformthreadapi.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {
    @GetMapping("/hello")
    fun hello() {
        Thread.sleep(100)
    }
}