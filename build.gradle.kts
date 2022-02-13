allprojects {
    group = "com.gnefedev"
    buildscript {
        repositories {
            mavenCentral()
        }
    }
}

subprojects {
    tasks.withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    repositories {
        mavenCentral()
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "7.4"
}
