import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
    implementation("io.projectreactor:reactor-core")
}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}