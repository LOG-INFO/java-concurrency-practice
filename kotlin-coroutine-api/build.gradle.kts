dependencies {
    implementation(project(":domain"))
    implementation(project(":core"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation(kotlin("stdlib-jdk8"))
}