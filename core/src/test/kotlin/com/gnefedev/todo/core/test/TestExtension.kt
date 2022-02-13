package com.gnefedev.todo.core.test

import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest

@ExtendWith(DbCleaner::class)
@SpringBootTest
annotation class TestExtension
