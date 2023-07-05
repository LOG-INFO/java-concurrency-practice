## Version Compatibility - [Gradle - Java - Kotlin](https://docs.gradle.org/current/userguide/compatibility.html)

- `Gradle 8.0.2`
- `Kotlin 1.9.0-Beta`
- `JVM 20`
- `Spring Boot 3.1.0`
- `Apache Tomcat 10.1.8` or `Netty 4.1.92.Final`

## JVM Options

```
-server
-Xss500k
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

#### Non-GUI mode

```bash
$ jmeter -n -t jmeter/JMeter_Config.jmx -l jmeter/jmeter.jtl
```

#### Options

- `-n`: It specifies JMeter is to run in non-gui mode
- `-t`: Name of JMX file that contains the Test Plan
- `-l`: Name of JTL(JMeter text logs) file to log results
- `-j`: Name of JMeter run log file

#### CPU / Memory

#### Performance

#### Threads

## 참고

- https://youtrack.jetbrains.com/issue/KT-57669
  - Kotlin 1.9.0-Beta 부터 JVM 20 지원

## JEP

- [JEP 425: Virtual Threads (Preview) (JDK 19)](https://openjdk.org/jeps/425)
- [JEP 436: Virtual Threads (Second Preview) (JDK 20)](https://openjdk.org/jeps/436)
- [JEP 444: Virtual Threads (JDK 21)](https://openjdk.org/jeps/444)

## 관련 아티클

- https://spring.io/blog/2022/10/11/embracing-virtual-threads
- https://perfectacle.github.io/2022/12/29/look-over-java-virtual-threads/