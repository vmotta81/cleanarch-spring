import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("plugin.spring") version "1.4.21"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation(project(":usecases"))
}

tasks.getByName<BootJar>("bootJar") { enabled = false }
tasks.getByName<Jar>("jar") { enabled = true }