package com.kodego.app.todolyplus_todolist.db

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class TaskDao {

    var dbReference: DatabaseReference = Firebase.database.reference

    //save task
    fun addTask(task: Task){
        dbReference.push().setValue(task)
    }

    //view all tasks
    fun getTasks(): Query{
        return dbReference.orderByKey()
    }
}