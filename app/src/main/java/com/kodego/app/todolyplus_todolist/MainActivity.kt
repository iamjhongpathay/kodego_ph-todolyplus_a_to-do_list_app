package com.kodego.app.todolyplus_todolist

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.kodego.app.todolyplus_todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Error: .IllegalStateException: Activity com.kodego.app.todolyplus_todolist.MainActivity@8f85dc7 does not have a NavController set on 2131230923
        //Solution: Change the FragmentContainerView to fragment in activity_main.xml
        setupActionBarWithNavController(findNavController(R.id.fragment))
        //changing the color of the app bar
//        supportActionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.white)))
    }

    //function of back arrow at the app bar
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}