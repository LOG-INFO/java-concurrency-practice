package info.log.core.config

import info.log.core.client.HelloClient
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
        helloClient.hello()

        val threads = List(50) {
            Thread.ofVirtual().unstarted {
                repeat(10) {
                    helloClient.hello()
                }
            }
        }

        threads.forEach{it.start()}
        threads.forEach{it.join()}

        log.info("Finished Warming Up")
    }
}