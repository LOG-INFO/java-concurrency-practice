import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation(project(":domain"))
    implementation("io.projectreactor:reactor-core")
    implementation("io.micrometer:micrometer-core")
    implementation("org.springframework.boot:spring-boot")
    implementation("org.springframework:spring-web")
    implementation("org.slf4j:slf4j-api")
}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}