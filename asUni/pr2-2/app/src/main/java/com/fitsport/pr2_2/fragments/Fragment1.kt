package com.fitsport.pr2_2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.fitsport.pr2_2.R

class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bF1 = view.findViewById<Button>(R.id.btn1)
        val bF2 = view.findViewById<Button>(R.id.btn2)
        val bF3 = view.findViewById<Button>(R.id.btn3)
        val controller = findNavController()
        bF1.setOnClickListener{
            controller.navigate(R.id.fragment1)
        }
        bF2.setOnClickListener{
            controller.navigate(R.id.fragment2)
        }
        bF3.setOnClickListener{
            controller.navigate(R.id.fragment3)
        }

    }
}