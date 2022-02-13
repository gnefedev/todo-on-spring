package com.gnefedev.todo.app

import com.gnefedev.todo.core.config.CoreConfig
import com.gnefedev.todo.db.config.DbConfig
import com.gnefedev.todo.rest.config.RestConfig
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Import

fun main() {
    SpringApplication(Application::class.java).run()
}

@SpringBootApplication
@Import(
    CoreConfig::class,
    DbConfig::class,
    RestConfig::class
)
class Application
