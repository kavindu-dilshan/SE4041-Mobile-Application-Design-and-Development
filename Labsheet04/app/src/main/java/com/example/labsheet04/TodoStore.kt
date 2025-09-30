package com.example.labsheet04

// super basic in-memory storage (lost when app is killed)
object TodoStore {
    data class Todo(var title: String, var done: Boolean = false)
    val items = arrayListOf<Todo>()
}