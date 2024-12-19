package com.fitsport.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.fitsport.test.databinding.FragmentOneBinding


class OneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentOne = FragmentOneBinding.inflate(inflater)
        return fragmentOne.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = OneFragment()
    }
}