package com.gnefedev.todo.core.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@ComponentScan(basePackages = ["com.gnefedev.todo.core.services"])
@Configuration
class CoreConfig
