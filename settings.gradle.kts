
rootProject.name = "java-concurrency-practice"
include("platform-thread-api")
include("virtual-thread-api")
include("reactor-netty-api")
include("kotlin-coroutine-api")
include("domain")
include("core")

pluginManagement {
    repositories {
        maven(url = "https://repo.spring.io/milestone")
        gradlePluginPortal()
    }
}