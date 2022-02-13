plugins {
    kotlin("jvm")
    id("org.jetbrains.kotlin.plugin.spring") version Versions.kotlin
}

tasks.test {
    useJUnitPlatform {}
}

dependencies {
    implementation(project(":db"))
    implementation(project(":common"))

    implementation("io.github.microutils:kotlin-logging:${Versions.kotlinLogging}")
    implementation("org.springframework.boot:spring-boot-starter:${Versions.springBoot}") {
        exclude(module = "commons-logging")
    }
    implementation("org.liquibase:liquibase-core:${Versions.liquibase}")

    testImplementation("org.postgresql:postgresql:${Versions.postgres}")
    testImplementation("org.springframework:spring-jdbc:${Versions.spring}")

    testImplementation("org.springframework.boot:spring-boot-starter-test:${Versions.springBoot}") {
        exclude(module = "commons-logging")
        exclude(module = "junit")
    }
    testImplementation("org.junit.jupiter:junit-jupiter-api:${Versions.jupiter}")
    testImplementation("org.testcontainers:postgresql:${Versions.testcontainers}")
    testImplementation("org.testcontainers:junit-jupiter:${Versions.testcontainers}")
    testImplementation("io.kotest:kotest-assertions-core:${Versions.kotest}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.jupiter}")
}
