package com.kodego.app.todolyplus_todolist.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.kodego.app.todolyplus_todolist.R
import com.kodego.app.todolyplus_todolist.adapters.TaskAdapter
import com.kodego.app.todolyplus_todolist.databinding.FragmentListBinding
import com.kodego.app.todolyplus_todolist.db.Task
import com.kodego.app.todolyplus_todolist.db.TaskDao

class ListFragment : Fragment() {
    lateinit var binding : FragmentListBinding
    lateinit var taskAdapter : TaskAdapter
    var taskDao = TaskDao()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListBinding.inflate(layoutInflater)
        viewTask()

        binding.fabAddTask.setOnClickListener(){
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }
        return binding.root

    }

    private fun viewTask(){
        taskDao.getTasks().addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var tasks: ArrayList<Task> = ArrayList<Task>()
                var dataFromDB = snapshot.children

                for(data in dataFromDB){
                    var taskName = data.child("task").value.toString()
                    var description = data.child("description").value.toString()
                    var task = Task(taskName, description)

                    tasks.add(task)
                    taskAdapter = TaskAdapter(tasks)
                    binding.recyclerViewTaskList.adapter = taskAdapter
                    binding.recyclerViewTaskList.layoutManager = LinearLayoutManager(requireContext())
                    taskAdapter.setData(tasks)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}