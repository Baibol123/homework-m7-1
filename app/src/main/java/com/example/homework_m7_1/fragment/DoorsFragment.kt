package com.example.homework_m7_1.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_m7_1.Adapter.DoorAdapter
import com.example.homework_m7_1.R
import com.example.homework_m7_1.data.AppDatabase
import com.example.homework_m7_1.databinding.FragmentDoorsBinding
import com.example.homework_m7_1.fragment.viewModel.DoorViewModel
import com.example.homework_m7_1.fragment.viewModel.DoorViewModelFactory


class DoorsFragment : Fragment() {

    private var _binding: FragmentDoorsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DoorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("DoorsFragment", "onCreateView")
        _binding = FragmentDoorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = DoorViewModelFactory(AppDatabase.getDatabase(requireContext()).doorDao)
        viewModel = ViewModelProvider(this, factory).get(DoorViewModel::class.java)

        val doorAdapter = DoorAdapter(emptyList())
        binding.rvDoors.layoutManager = LinearLayoutManager(requireContext())
        binding.rvDoors.adapter = doorAdapter

        viewModel.doors.observe(viewLifecycleOwner) { doors ->
            doorAdapter.updateDoors(doors)
        }

        viewModel.refreshDoors()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}