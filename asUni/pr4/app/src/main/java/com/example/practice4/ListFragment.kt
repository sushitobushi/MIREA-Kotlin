package com.example.practice4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DateAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        val navigateButton = view.findViewById<Button>(R.id.button_to_list)
        recyclerView = view.findViewById(R.id.recyclerView)
        loadDates()

        navigateButton.setOnClickListener {
            findNavController().navigate(R.id.cameraFragment)
        }

        return view
    }

    private fun loadDates() {
        val photoDir = File(requireContext().filesDir, "photos")
        val file = File(photoDir, "date.txt")
        val dates = if (file.exists()) {
            file.readLines().sortedDescending()
        } else {
            emptyList()
        }

        adapter = DateAdapter(dates)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }
}
