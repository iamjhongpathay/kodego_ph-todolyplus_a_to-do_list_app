package com.kodego.app.todolyplus_todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.kodego.app.todolyplus_todolist.databinding.FragmentAddBinding
import com.kodego.app.todolyplus_todolist.db.Task
import com.kodego.app.todolyplus_todolist.db.TaskDao

class AddFragment : Fragment() {

    lateinit var binding : FragmentAddBinding
    var taskDao = TaskDao()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(layoutInflater)

        binding.btnCancelAddTask.setOnClickListener(){
            Navigation.findNavController(requireView()).navigateUp()
        }

        binding.btnAddTask.setOnClickListener(){
            try{
                if(binding.etEnterTaskTitle.text?.isEmpty() == true){
                    Toast.makeText(requireContext(), "Task field is required!", Toast.LENGTH_SHORT).show()

                }else{
                    var taskName: String = binding.etEnterTaskTitle.text.toString()
                    var description: String = binding.etEnterDescription.text.toString()
                    var isTaskDone: Boolean = false

                    taskDao.addTask(Task(taskName, description, isTaskDone))

                    Toast.makeText(requireContext(), "New Task Added!", Toast.LENGTH_SHORT).show()

                    Navigation.findNavController(requireView()).navigateUp()

                }
            }catch (e: Exception){
                Toast.makeText(requireContext(), "$e", Toast.LENGTH_SHORT).show()
            }
        }


        return binding.root
    }


}