package com.gnefedev.todo.db.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan("com.gnefedev.todo.db.entities")
@EnableJpaRepositories("com.gnefedev.todo.db.repositories")
@PropertySource("classpath:application-db.properties")
class DbConfig
