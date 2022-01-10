package com.jcs.jarpaper.ui.fragment.latest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.jcs.jarpaper.databinding.FragmentLatestBinding
import com.jcs.jarpaper.ui.adapter.LatestAdaper
import com.jcs.jarpaper.utils.DataResource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LatestFragment : Fragment() {

    private var _binding: FragmentLatestBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LatestViewModel by viewModels()
    private lateinit var adapter: LatestAdaper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLatestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.lastWallpapers.observe(viewLifecycleOwner, {
            when (it.status) {
                DataResource.Status.LOADING -> {
                    Toast.makeText(requireContext(), "Carregando...", Toast.LENGTH_SHORT).show()
                }
                DataResource.Status.SUCCESS -> {
                    if (!it.data.isNullOrEmpty()) adapter.submitList(it.data)
                }
                DataResource.Status.ERROR -> {
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun setupRecyclerView() {
        adapter = LatestAdaper()
        binding.rvWallpaper.layoutManager = LinearLayoutManager(requireContext())
        binding.rvWallpaper.adapter = adapter
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}