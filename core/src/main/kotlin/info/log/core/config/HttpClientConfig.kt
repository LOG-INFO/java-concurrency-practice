package info.log.core.config

import info.log.core.client.HelloClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.support.RestTemplateAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import org.springframework.web.util.DefaultUriBuilderFactory


@Configuration
class HttpClientConfig(
    @Value("\${server.port}")
    private val port: String,
) {

    @Bean
    fun localhostRestTemplate(): RestTemplate {
        return RestTemplateBuilder().uriTemplateHandler(DefaultUriBuilderFactory("http://localhost:${port}")).build()
    }

    @Bean
    fun httpServiceProxyFactory(): HttpServiceProxyFactory {
        val restTemplate = localhostRestTemplate()
        return HttpServiceProxyFactory.builderFor(RestTemplateAdapter.create(restTemplate)).build()
    }

    @Bean
    fun helloClient(): HelloClient {
        return httpServiceProxyFactory().createClient(HelloClient::class.java)
    }
}