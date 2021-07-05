import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot") version "2.4.1"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    kotlin("plugin.jpa") version "1.4.10"
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("br.com.caelum.stella:caelum-stella-core:2.1.4")

    implementation(project(":entities"))
    implementation(project(":usecases"))
}

tasks.getByName<BootJar>("bootJar") { enabled = false }
tasks.getByName<Jar>("jar") { enabled = true }