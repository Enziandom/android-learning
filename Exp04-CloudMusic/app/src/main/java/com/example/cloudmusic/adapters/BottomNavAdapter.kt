package com.example.cloudmusic.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class BottomNavAdapter(
  fragmentActivity: FragmentActivity,
  private var fragments: List<Fragment>
) : FragmentStateAdapter(fragmentActivity) {

  override fun createFragment(position: Int): Fragment {
    return fragments[position]
  }

  override fun getItemCount(): Int {
    return fragments.size
  }

}