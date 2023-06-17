package info.log.virtualthreadapi

import org.apache.coyote.ProtocolHandler
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.core.task.AsyncTaskExecutor
import org.springframework.core.task.support.TaskExecutorAdapter
import java.util.concurrent.Executors


@SpringBootApplication
class VirtualThreadApiApplication {
    @Bean(TaskExecutionAutoConfiguration.APPLICATION_TASK_EXECUTOR_BEAN_NAME)
    fun asyncTaskExecutor(): AsyncTaskExecutor {
        return TaskExecutorAdapter(Executors.newVirtualThreadPerTaskExecutor())
    }

    @Bean
    fun protocolHandlerVirtualThreadExecutorCustomizer(): TomcatProtocolHandlerCustomizer<*> {
        return TomcatProtocolHandlerCustomizer { protocolHandler: ProtocolHandler ->
            protocolHandler.executor = Executors.newVirtualThreadPerTaskExecutor()
        }
    }
}

fun main(args: Array<String>) {
    runApplication<VirtualThreadApiApplication>(*args)
}