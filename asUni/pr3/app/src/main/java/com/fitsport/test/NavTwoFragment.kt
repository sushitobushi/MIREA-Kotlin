package com.fitsport.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.fitsport.test.databinding.FragmentNavTwoBinding

class NavTwoFragment : Fragment() {
    private lateinit var binding: FragmentNavTwoBinding
    private val viewModel: NavViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNavTwoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            viewModel.navigateTo(R.id.navOneFragment)
        }

        binding.btn2.setOnClickListener {
            viewModel.navigateTo(R.id.navTwoFragment)
        }

        binding.btn3.setOnClickListener {
            viewModel.navigateTo(R.id.navTreeFragment)
        }

        // Наблюдаем за изменениями в LiveData для навигации
        viewModel.navigateToFragment.observe(viewLifecycleOwner, Observer { fragmentId ->
            fragmentId?.let {
                findNavController().navigate(it)
                viewModel.navigationComplete() // Сбрасываем значение после навигации
            }
        })
    }
}
