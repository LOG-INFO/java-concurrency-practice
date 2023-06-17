## 

## Version Compatibility

### [Gradle - Java - Kotlin](https://docs.gradle.org/current/userguide/compatibility.html)

- Gradle 8.0.2
- JVM 20
- Kotlin 1.9.0-Beta
- Spring Boot 3.1.0
- Apache Tomcat 10.1.8

참고

- https://youtrack.jetbrains.com/issue/KT-57669
  - Kotlin 1.9.0-Beta 부터 JVM 20 지원

## 관련 아티클

- https://spring.io/blog/2022/10/11/embracing-virtual-threads

## Trouble Shooting

### Kotlin JVM 버전 관련 컴파일러 에러

#### 문제

![img.png](README-image/img.png)

#### 해결

- project settings에서 Language Level 변경
  - ![img_1.png](README-image/img_1.png)
- IntelliJ 버그인지, 껐다 켜줘야 적용됨