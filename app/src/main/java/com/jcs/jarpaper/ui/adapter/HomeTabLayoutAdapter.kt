package com.jcs.jarpaper.ui.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jcs.jarpaper.ui.fragment.latest.LatestFragment
import com.jcs.jarpaper.ui.fragment.popular.PopularFragment
import com.jcs.jarpaper.ui.fragment.random.RandomFragment

/**
 * Created by Jardson Costa on 28/11/2021.
 */

class HomeTabLayoutAdapter(fragment: Fragment, private val  titles: Array<String>): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = titles.size

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> LatestFragment()
            1 -> PopularFragment()
            2 -> RandomFragment()
            else -> LatestFragment()
        }
    }
}