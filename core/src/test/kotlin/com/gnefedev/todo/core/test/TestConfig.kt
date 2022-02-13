package com.gnefedev.todo.core.test

import com.gnefedev.todo.core.config.CoreConfig
import com.gnefedev.todo.db.config.DbConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.Import
import org.springframework.test.context.support.TestPropertySourceUtils
import org.testcontainers.containers.PostgreSQLContainer

@SpringBootApplication
@Import(CoreConfig::class, DbConfig::class)
class TestConfig

class DockerPostgresDataSourceInitializer : ApplicationContextInitializer<ConfigurableApplicationContext?> {
    override fun initialize(applicationContext: ConfigurableApplicationContext?) {
        val postgresDBContainer: PostgreSQLContainer<*> = PostgreSQLContainer("postgres:9.4")
        postgresDBContainer.start()
        TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
            applicationContext!!,
            "spring.datasource.url=" + postgresDBContainer.jdbcUrl,
            "spring.datasource.username=" + postgresDBContainer.username,
            "spring.datasource.password=" + postgresDBContainer.password
        )
    }
}
