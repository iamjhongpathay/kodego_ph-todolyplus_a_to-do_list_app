package com.kodego.app.todolyplus_todolist.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodego.app.todolyplus_todolist.databinding.RowTasksBinding
import com.kodego.app.todolyplus_todolist.db.Task

class TaskAdapter(var taskModel: MutableList<Task>) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){

    inner class TaskViewHolder(var binding: RowTasksBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowTasksBinding.inflate(layoutInflater, parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.binding.apply {
            tvTaskName.text = taskModel[position].task
            tvDescription.text = taskModel[position].description
        }
    }

    override fun getItemCount(): Int {
        return taskModel.size
    }

    //refresh the recyclerview
    fun setData(task: MutableList<Task>){
        this.taskModel = task
        notifyDataSetChanged()
    }
}