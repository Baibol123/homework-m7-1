package com.example.homework_m7_1.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_m7_1.Adapter.CameraAdapter
import com.example.homework_m7_1.R
import com.example.homework_m7_1.data.AppDatabase
import com.example.homework_m7_1.databinding.FragmentCameraBinding
import com.example.homework_m7_1.fragment.viewModel.CameraViewModel
import com.example.homework_m7_1.fragment.viewModel.CameraViewModelFactory


class CameraFragment : Fragment() {

    private var _binding: FragmentCameraBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CameraViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("CameraFragment", "onCreateView")
        _binding = FragmentCameraBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = CameraViewModelFactory(AppDatabase.getDatabase(requireContext()).cameraDao)
        viewModel = ViewModelProvider(this, factory).get(CameraViewModel::class.java)

        val cameraAdapter = CameraAdapter(emptyList())
        binding.rvCamers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvCamers.adapter = cameraAdapter

        viewModel.cameras.observe(viewLifecycleOwner) { cameras ->
            cameraAdapter.updateCameras(cameras)
        }

        viewModel.refreshCameras()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}