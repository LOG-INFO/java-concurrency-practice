package info.log.kotlincoroutineapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication(scanBasePackages = ["info.log.kotlincoroutineapi", "info.log.core"])
class KotlinCoroutineApiApplication {
}

fun main(args: Array<String>) {
    runApplication<KotlinCoroutineApiApplication>(*args)
}