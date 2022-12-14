package com.example.shopping.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class TabBarFragmentAdapter extends FragmentStateAdapter {

  private final List<Fragment> fragments;

  public TabBarFragmentAdapter(@NonNull FragmentActivity fragmentActivity, List<Fragment> list) {
    super(fragmentActivity);
    this.fragments = list;
  }

  @NonNull
  @Override
  public Fragment createFragment(int position) {
    return fragments.get(position);
  }

  @Override
  public int getItemCount() {
    return fragments.size();
  }

}