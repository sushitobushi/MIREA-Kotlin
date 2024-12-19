package com.fitsport.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fitsport.test.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentTwo = FragmentTwoBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return fragmentTwo.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = TwoFragment()
    }
}