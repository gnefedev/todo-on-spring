package com.gnefedev.todo.core.test

import com.gnefedev.todo.core.models.TodoItem
import com.gnefedev.todo.core.services.TodoListService
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired


@TestExtension
class TodoListServiceTest @Autowired constructor(
    val todoListService: TodoListService
) {
    @Test
    fun `add one item and list all`() {
        todoListService.add(TodoItem(TodoItem.Id.generate(), "first"))

        todoListService.listAll() shouldHaveSize 1
        todoListService.listAll().first().message shouldBe "first"
    }

    @Test
    fun `add item is idempotent`() {
        val id = TodoItem.Id.generate()
        todoListService.add(TodoItem(id, "first"))
        todoListService.add(TodoItem(id, "first"))

        todoListService.listAll() shouldHaveSize 1
        todoListService.listAll().first().message shouldBe "first"
    }

    @Test
    fun `add several item and list all`() {
        todoListService.add(TodoItem(TodoItem.Id.generate(), "first"))
        todoListService.add(TodoItem(TodoItem.Id.generate(), "second"))

        todoListService.listAll() shouldHaveSize 2
        todoListService.listAll().map { it.message } shouldContainExactlyInAnyOrder listOf("first", "second")
    }

    @Test
    fun `mark a todo item as done`() {
        //given
        val idOfFirst = TodoItem.Id.generate()
        todoListService.add(TodoItem(idOfFirst, "first"))
        todoListService.listAll().first { it.id == idOfFirst }.status shouldBe TodoItem.Status.OPEN

        //when
        todoListService.markDone(idOfFirst)

        //then
        todoListService.listAll().first { it.id == idOfFirst }.status shouldBe TodoItem.Status.DONE
    }

    @Test
    fun `delete a todo item`() {
        //given
        val idOfFirst = TodoItem.Id.generate()
        todoListService.add(TodoItem(idOfFirst, "first"))
        todoListService.listAll() shouldHaveSize 1

        //when
        todoListService.delete(idOfFirst)

        //then
        todoListService.listAll() shouldHaveSize 0
    }
}

