package info.log.platformthreadapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication(scanBasePackages = ["info.log.platformthreadapi", "info.log.core"])
class PlatformThreadApiApplication {
}

fun main(args: Array<String>) {
    runApplication<PlatformThreadApiApplication>(*args)
}