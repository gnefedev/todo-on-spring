package com.gnefedev.todo.core.models

import com.gnefedev.todo.common.model.TodoItemStatus
import java.util.*

data class TodoItem(
    val id: Id,
    val message: String,
    val status: TodoItemStatus,
//    val date: Instant
//        Instant.now().plus(Duration.ofDays(1))

) {
    data class Id(
        val uniq: UUID
    ) {
        companion object {
            fun generate() = Id(UUID.randomUUID())
        }
    }
}
