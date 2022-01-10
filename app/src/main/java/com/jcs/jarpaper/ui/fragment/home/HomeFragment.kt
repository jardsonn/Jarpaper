package com.jcs.jarpaper.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.jcs.jarpaper.R
import com.jcs.jarpaper.databinding.FragmentHomeBinding
import com.jcs.jarpaper.ui.adapter.HomeTabLayoutAdapter

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val titles = resources.getStringArray(R.array.tab_layout_title)
        val viewPage =  binding.mainViewpage
        viewPage.adapter = HomeTabLayoutAdapter(this, titles)
        viewPage.isUserInputEnabled = false

        TabLayoutMediator(binding.homeTablayout, viewPage){ tab, position ->
            tab.text = titles[position]
        }.attach()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}