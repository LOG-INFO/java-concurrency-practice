package info.log.platformthreadapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class PlatformThreadApiApplication {
}

fun main(args: Array<String>) {
    runApplication<PlatformThreadApiApplication>(*args)
}