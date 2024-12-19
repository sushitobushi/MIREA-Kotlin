package com.fitsport.test

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.fitsport.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        // Наблюдаем за изменениями в currentFragment из ViewModel
        viewModel.currentFragment.observe(this, Observer { fragment ->
            supportFragmentManager.beginTransaction().replace(R.id.fragment, fragment).commit()
        })

        // Устанавливаем обработчики для кнопок фрагментов
        binding.oneFragment.setOnClickListener {
            viewModel.selectFragment(OneFragment.newInstance())
        }

        binding.twoFragment.setOnClickListener {
            viewModel.selectFragment(TwoFragment.newInstance())
        }

        binding.treeFragment.setOnClickListener {
            viewModel.selectFragment(TreeFragment.newInstance())
        }

        // Устанавливаем начальный фрагмент
        viewModel.selectFragment(OneFragment.newInstance())
    }
}
