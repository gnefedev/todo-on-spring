package com.gnefedev.todo.core.services

import com.gnefedev.todo.common.model.TodoItemStatus
import com.gnefedev.todo.core.models.TodoItem
import com.gnefedev.todo.db.entities.TodoItemEntity
import com.gnefedev.todo.db.repositories.TodoItemsRepository
import org.springframework.stereotype.Service

@Service
class TodoListService(
    private val repository: TodoItemsRepository
) {
    fun add(item: TodoItem) {
        repository.save(item.toEntity())
    }

    fun delete(id: TodoItem.Id) {
        repository.deleteById(id.uniq)
    }

    fun markDone(id: TodoItem.Id) {
        val original = repository.findById(id.uniq).get()
        val edited = original.copy(status = TodoItemStatus.DONE)
        repository.save(edited)
    }

    fun listAll(): List<TodoItem> = repository.findAll()
        .map { it.toModel() }
}

private fun TodoItemEntity.toModel() = TodoItem(
    id = TodoItem.Id(id),
    message = message,
    status = status
)

private fun TodoItem.toEntity() = TodoItemEntity(
    id.uniq,
    message,
    status
)

