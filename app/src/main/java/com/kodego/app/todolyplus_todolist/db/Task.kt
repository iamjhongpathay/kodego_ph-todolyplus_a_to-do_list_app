package com.kodego.app.todolyplus_todolist.db

data class Task(var task: String, var description: String, var isTaskDone: Boolean = false)