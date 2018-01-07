package com.teuch.pentateuchapp.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teuch.pentateuchapp.R;
import com.teuch.pentateuchapp.adapter.PagerAdapter;


public class AboutUsFragment extends Fragment  {
    ViewPager viewPager;
    private View rootView;

     static String title;
    static int page;

    public AboutUsFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_about_us, container, false);

        viewPager = (ViewPager) rootView.findViewById(R.id.vpPager);
        //tabLayout = (TabLayout)rootView.findViewById(R.id.tab);


        return rootView;
    }

    public static Fragment newInstance(int i, String s) {
        AboutUsFragment fragmentFirst = new AboutUsFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }
}