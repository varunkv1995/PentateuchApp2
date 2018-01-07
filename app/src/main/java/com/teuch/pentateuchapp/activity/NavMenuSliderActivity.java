package com.teuch.pentateuchapp.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.teuch.pentateuchapp.R;
import com.teuch.pentateuchapp.adapter.PagerAdapter;
import com.teuch.pentateuchapp.fragment.AboutUsFragment;
import com.teuch.pentateuchapp.fragment.ClientFragment;
import com.teuch.pentateuchapp.fragment.ContactFragment;
import com.teuch.pentateuchapp.fragment.ServiceFragment;
import com.teuch.pentateuchapp.fragment.TechnologiesFragment;

/**
 * Created by Md.Saif on 05-01-2018.
 */

public class NavMenuSliderActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    PagerAdapter adapterViewPager;
    /* private LinearLayout linearLayout;
     private TabLayout tabLayout;
     private TextView[] textViews;
     private  int[] colors;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        final ViewPager vpPager = (ViewPager) findViewById(R.id.vpPager);
                adapterViewPager = new PagerAdapter(getSupportFragmentManager());
                vpPager.setAdapter(adapterViewPager);
        vpPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            // This method will be invoked when a new page becomes selected.
            @Override
            public void onPageSelected(int position) {

            }

            // This method will be invoked when the current page is scrolled
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // Code goes here
            }

            // Called when the scroll state changes:
            // SCROLL_STATE_IDLE, SCROLL_STATE_DRAGGING, SCROLL_STATE_SETTLING
            @Override
            public void onPageScrollStateChanged(int state) {
                // Code goes here
            }
        });
            }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    // ...
        }