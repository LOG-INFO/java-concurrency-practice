## Version Compatibility - [Gradle - Java - Kotlin](https://docs.gradle.org/current/userguide/compatibility.html)

- `Gradle 8.0.2`
- `Kotlin 1.9.0-Beta`
- `JVM 20`
- `Spring Boot 3.1.0`
- `Apache Tomcat 10.1.8` or `Netty 4.1.92.Final`

## JVM Options

```
-server
-Xss200k
-Xms1g
-Xmx1g
-XX:NativeMemoryTracking=detail
-XX:Tier3CompileThreshold=100
-XX:Tier4CompileThreshold=100
--enable-preview
```

## 비교

- Tomcat + Platform Threads
- Netty + Reactor
- Netty + Kotlin Coroutines
- Tomcat + Virtual Threads

### Load Test

#### CPU / Memory

#### Performance

#### Threads

## 참고

- https://youtrack.jetbrains.com/issue/KT-57669
    - Kotlin 1.9.0-Beta 부터 JVM 20 지원

## 관련 아티클

- https://spring.io/blog/2022/10/11/embracing-virtual-threads