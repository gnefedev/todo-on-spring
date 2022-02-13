plugins {
    kotlin("jvm")
    id("org.jetbrains.kotlin.plugin.spring") version Versions.kotlin
    application
}

tasks.test {
    useJUnitPlatform {}
}

dependencies {
    implementation(project(":db"))
    implementation(project(":core"))
    implementation(project(":rest"))

    implementation("org.jetbrains.kotlin:kotlin-reflect:${Versions.kotlin}")

    runtimeOnly("org.postgresql:postgresql:${Versions.postgres}")

    implementation("org.springframework.boot:spring-boot-starter:${Versions.springBoot}") {
        exclude(module = "commons-logging")
    }
}

application {
    mainClass.set("com.gnefedev.todo.app.ApplicationKt")
}
