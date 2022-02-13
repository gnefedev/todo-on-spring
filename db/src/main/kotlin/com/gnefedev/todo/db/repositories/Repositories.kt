package com.gnefedev.todo.db.repositories

import com.gnefedev.todo.db.entities.TodoItemEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TodoItemsRepository : CrudRepository<TodoItemEntity, UUID>
