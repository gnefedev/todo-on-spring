plugins {
    kotlin("jvm")
    id("org.jetbrains.kotlin.plugin.spring") version Versions.kotlin
}

tasks.test {
    useJUnitPlatform {}
}

dependencies {
    implementation(project(":core"))
    implementation(project(":common"))

    implementation("org.springframework.boot:spring-boot-starter-web:${Versions.springBoot}")
    implementation("org.springframework.boot:spring-boot-starter-validation:${Versions.springBoot}")

}
