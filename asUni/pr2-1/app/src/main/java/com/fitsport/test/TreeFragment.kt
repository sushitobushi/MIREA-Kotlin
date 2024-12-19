package com.fitsport.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fitsport.test.databinding.FragmentTreeBinding

class TreeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentTree = FragmentTreeBinding.inflate(inflater)
        return fragmentTree.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = TreeFragment()
    }
}