package com.gnefedev.todo.rest.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.gnefedev.todo.common.model.TodoItemStatus
import java.util.*
import javax.validation.constraints.NotBlank

data class TodoItemFull @JsonCreator constructor(
    @JsonProperty("id") val id: UUID,
    @get:NotBlank
    @JsonProperty("message") val message: String,
    @JsonProperty("status") val status: TodoItemStatus
)
