package com.gnefedev.todo.core.test

import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.test.context.junit.jupiter.SpringExtension

private val EXCLUSIONS = setOf(
    "DATABASECHANGELOG",
    "DATABASECHANGELOGLOCK"
)

class DbCleaner : AfterEachCallback {
    override fun afterEach(context: ExtensionContext) {
        val jdbcTemplate = SpringExtension.getApplicationContext(context).getBean(JdbcTemplate::class.java)
        val allTables = jdbcTemplate.queryForList(
            "SELECT tablename FROM pg_catalog.pg_tables " +
                "WHERE schemaname != 'pg_catalog' AND schemaname != 'information_schema'",
            String::class.java
        )
        val tablesToClean = allTables
            .filterNot { it in EXCLUSIONS }
            .toSet()
        jdbcTemplate.execute(tablesToClean.joinToString(";") { "TRUNCATE TABLE $it CASCADE" })
    }
}
