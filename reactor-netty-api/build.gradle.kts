dependencies {
    implementation(project(":domain"))
    implementation(project(":core"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation(kotlin("stdlib-jdk8"))
}