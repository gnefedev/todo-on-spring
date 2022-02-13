package com.gnefedev.todo.db.entities

import com.gnefedev.todo.common.model.TodoItemStatus
import java.util.*
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Id

@Entity(name = "TodoItem")
data class TodoItemEntity(
    @field:Id
    val id: UUID,
    val message: String,
    @field:Enumerated(EnumType.STRING)
    val status: TodoItemStatus
)
