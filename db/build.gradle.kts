plugins {
    kotlin("jvm")
    id("org.jetbrains.kotlin.plugin.spring") version Versions.kotlin
    id("org.jetbrains.kotlin.plugin.allopen") version Versions.kotlin
    id("org.jetbrains.kotlin.plugin.noarg") version Versions.kotlin
}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
    annotation("javax.persistence.MappedSuperclass")
}
noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.Embeddable")
}

dependencies {
    implementation(project(":common"))

    implementation("io.github.microutils:kotlin-logging:${Versions.kotlinLogging}")
    implementation("org.springframework.boot:spring-boot-starter:${Versions.springBoot}") {
        exclude(module = "commons-logging")
    }
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:${Versions.springBoot}")
    api("org.springframework.data:spring-data-commons:${Versions.springData}")
    implementation("org.liquibase:liquibase-core:${Versions.liquibase}")
}
