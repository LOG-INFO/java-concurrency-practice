package info.log.core.config

import info.log.core.client.HelloClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import reactor.netty.http.client.HttpClient
import reactor.netty.resources.ConnectionProvider
import java.time.Duration


@Configuration
class HttpClientConfig(
    @Value("\${server.port}")
    private val port: String,
) {

    @Bean
    fun localhostWebClient(): WebClient {
        val provider = ConnectionProvider.builder("custom-provider")
            .maxConnections(1000)
            .pendingAcquireMaxCount(1000)
            .pendingAcquireTimeout(Duration.ofSeconds(3))
            .fifo()
            .metrics(true)
            .build()
        val httpClient: HttpClient = HttpClient.create(provider)
            .also { it.warmup().block() }
        return WebClient.builder()
            .baseUrl("http://localhost:${port}")
            .clientConnector(ReactorClientHttpConnector(httpClient))
            .build()
    }

    @Bean
    fun httpServiceProxyFactory(): HttpServiceProxyFactory {
        val webClient = localhostWebClient()
        return HttpServiceProxyFactory
            .builder(WebClientAdapter.forClient(webClient))
            .build()
    }

    @Bean
    fun helloClient(): HelloClient {
        return httpServiceProxyFactory().createClient(HelloClient::class.java)
    }
}