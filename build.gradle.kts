import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootJar

object DependencyVersions {
    const val KOTLIN_VERSION = "1.9.20-Beta2"
}

plugins {
    id("org.springframework.boot") version "3.2.0-M2"
    id("io.spring.dependency-management") version "1.1.2"
    kotlin("jvm") version "1.9.20-Beta2"
    kotlin("plugin.spring") version "1.9.20-Beta2"
}

repositories {
    mavenCentral()
    maven(url = "https://repo.spring.io/snapshot")
    maven(url = "https://repo.spring.io/milestone")
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")
    apply(plugin = "org.jetbrains.kotlin.plugin.spring")

    repositories {
        mavenCentral()
        maven(url = "https://repo.spring.io/snapshot")
        maven(url = "https://repo.spring.io/milestone")
    }

    group = "info.log"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks.test {
        useJUnitPlatform()
    }

    kotlin {
        jvmToolchain(21)

    }

    tasks.withType<KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "21"
        }
    }
}

tasks.getByName<BootJar>("bootJar") {
    enabled = false
}

subprojects {
    if (this.name != "core" && this.name != "domain") {
        tasks.getByName<BootJar>("bootJar") {
            enabled = true
            this.archiveFileName.set("app.jar")
        }
        tasks.getByName<Jar>("jar") {
            enabled = false
        }
    } else {
        tasks.getByName<BootJar>("bootJar") {
            enabled = false
        }
    }
}