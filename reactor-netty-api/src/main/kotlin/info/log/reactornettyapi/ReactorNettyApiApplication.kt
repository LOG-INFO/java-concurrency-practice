package info.log.reactornettyapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.client.WebClient


@SpringBootApplication(scanBasePackages = ["info.log.reactornettyapi", "info.log.core"])
class ReactorNettyApiApplication {
    @Bean
    fun webClient(): WebClient {
        return WebClient.create()
    }
}

fun main(args: Array<String>) {
    runApplication<ReactorNettyApiApplication>(*args)
}