package com.fitsport.test

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.fitsport.test.databinding.ActivityMainBinding
import com.fitsport.test.databinding.FragmentOneBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()


        binding.oneFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment, OneFragment.newInstance()).commit()
        }

        binding.twoFragment.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.fragment, TwoFragment.newInstance()).commit()
        }

        binding.treeFragment.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragment, TreeFragment.newInstance()).commit()
        }

        supportFragmentManager.
        beginTransaction().replace(R.id.fragment, OneFragment.newInstance()).commit()

    }
}