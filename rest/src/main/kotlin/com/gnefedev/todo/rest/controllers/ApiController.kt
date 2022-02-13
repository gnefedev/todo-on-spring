package com.gnefedev.todo.rest.controllers

import com.gnefedev.todo.core.models.TodoItem
import com.gnefedev.todo.core.services.TodoListService
import com.gnefedev.todo.rest.model.TodoItemCreationResponse
import com.gnefedev.todo.rest.model.TodoItemFull
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@Validated
@RequestMapping("/api")
class ApiController(
    val todoListService: TodoListService
) {
    @GetMapping(value = ["/listAll"], produces = [APPLICATION_JSON_VALUE])
    fun listAll(): List<TodoItemFull> = todoListService.listAll()
        .map { TodoItemFull(it.id.uniq, it.message, it.status) }

    @PutMapping(value = ["/add"], produces = [APPLICATION_JSON_VALUE])
    fun add(@Valid @RequestBody item: TodoItemFull): TodoItemCreationResponse {
        todoListService.add(
            TodoItem(
                id = TodoItem.Id(item.id),
                message = item.message,
                status = item.status
            )
        )
        return TodoItemCreationResponse(item.id)
    }
}
