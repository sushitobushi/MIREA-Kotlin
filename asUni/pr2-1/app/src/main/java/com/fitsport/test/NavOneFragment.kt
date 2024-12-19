package com.fitsport.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.findNavController
import com.fitsport.test.databinding.FragmentNavOneBinding

class NavOneFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nav_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        val bFr1 = view.findViewById<Button>(R.id.btn1)
        val bFr2 = view.findViewById<Button>(R.id.btn2)
        val bFr3 = view.findViewById<Button>(R.id.btn3)
        bFr1.setOnClickListener{
            controller.navigate(R.id.navOneFragment)
        }
        bFr2.setOnClickListener{
            controller.navigate(R.id.navTwoFragment)
        }
        bFr3.setOnClickListener{
            controller.navigate(R.id.navTreeFragment)
        }

    }
}