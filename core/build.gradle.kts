import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation(project(":domain"))
    implementation("io.projectreactor:reactor-core")
    implementation("io.micrometer:micrometer-core")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}