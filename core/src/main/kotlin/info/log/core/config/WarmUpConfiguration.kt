package info.log.core.config

import info.log.core.client.HelloClient
import kotlinx.coroutines.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener


@Configuration
class WarmUpConfiguration(
    private val helloClient: HelloClient,
) {
    val log: Logger = LoggerFactory.getLogger(this.javaClass)

    @EventListener(ApplicationReadyEvent::class)
    fun warmUpAfterStartup() {
        helloClient.hello().block()

        repeat(500) {
            warmUpRequest()
        }
        print("Finished Warming Up")
    }

    private fun warmUpRequest() {
        helloClient.hello()
            .subscribe({ log.info("Warming Up") }, { log.error(it.message) })
    }
}