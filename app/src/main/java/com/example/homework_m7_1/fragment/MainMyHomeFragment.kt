package com.example.homework_m7_1.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.homework_m7_1.Adapter.MainAdapter
import com.example.homework_m7_1.R
import com.example.homework_m7_1.databinding.FragmentMainMyHomeBinding
import com.google.android.material.tabs.TabLayoutMediator


class MainMyHomeFragment : Fragment() {

    private var _binding: FragmentMainMyHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var listAdapter: MainAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainMyHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }


    private fun setupViewPager() {
        listAdapter = MainAdapter(
            fragmentManager = childFragmentManager,
            lifecycle = viewLifecycleOwner.lifecycle
        )

        binding.vpCamdoor.adapter = listAdapter

        TabLayoutMediator(binding.tlCamadoor, binding.vpCamdoor) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()
    }

    private fun getTabTitle(position: Int): String {
        return when (position) {
            0 -> "Камеры"
            1 -> "Двери"
            else -> throw IllegalArgumentException("Unexpected position: $position")
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}