package com.teuch.pentateuchapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import com.teuch.pentateuchapp.activity.MainActivity;
import com.teuch.pentateuchapp.fragment.AboutUsFragment;
import com.teuch.pentateuchapp.fragment.ContactFragment;
import com.teuch.pentateuchapp.fragment.ServiceFragment;

import java.util.ArrayList;
import java.util.List;

public class PagerAdapter extends FragmentPagerAdapter {
    private  int NUM_ITEMS = 3;
    private List<Fragment> fragments;

    public void add(Fragment fragment){
        fragments.add(fragment);
    }

    public PagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        fragments = new ArrayList<>();
    }

    // Returns total number of pages
    @Override
    public int getCount() {
        return fragments.size();
    }

    // Returns the fragment to display for that page
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page " + position;
    }
}

