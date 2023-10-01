java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}
dependencies {
    implementation(project(":domain"))
    implementation(project(":core"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(kotlin("stdlib-jdk8"))
}