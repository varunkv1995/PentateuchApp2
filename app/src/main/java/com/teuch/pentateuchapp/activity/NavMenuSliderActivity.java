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

public class NavMenuSliderActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{
    ViewPager viewPager;
    private LinearLayout linearLayout;
    private TabLayout tabLayout;
    private TextView[] textViews;
    private  int[] colors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        tabLayout = (TabLayout)findViewById(R.id.tab);
        linearLayout=(LinearLayout)findViewById(R.id.linear);
        PagerAdapter pagerAdapter=new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(new AboutUsFragment(),"About Us");
        pagerAdapter.addFragment(new ServiceFragment(),"Services");
        pagerAdapter.addFragment(new ClientFragment(),"Cliental");
        pagerAdapter.addFragment(new TechnologiesFragment(),"Technologies");
        pagerAdapter.addFragment(new ContactFragment(),"Contact");

       /* pagerAdapter.addFragment(new AboutUsFragment(),"Page 1");
        pagerAdapter.addFragment(new ClientFragment(),"Page 2");
        pagerAdapter.addFragment(new ServiceFragment(),"Page 3");
        pagerAdapter.addFragment(new TechnologiesFragment(),"Page 4");
        pagerAdapter.addFragment(new ContactFragment(),"Page 5");*/
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(this);
        tabLayout.setupWithViewPager(viewPager);

        colors = new int[]{Color.YELLOW,Color.MAGENTA,Color.RED};
        //BUTTON
        textViews = new TextView[3];
        for (int i=0;i<3;i++){
            textViews[i] = new TextView(this);
            textViews[i].setText(Html.fromHtml("&#8226;"));
            textViews[i].setTextSize(30);
            textViews[i].setTextColor(Color.WHITE);
            linearLayout.addView(textViews[i]);
        }
        textViews[0].setTextColor(colors[0]);
    }
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for(int i=0;i<textViews.length;i++)
            textViews[i].setTextColor(Color.WHITE);
        textViews[position].setTextColor(colors[position]);
        tabLayout.setSelectedTabIndicatorColor(colors[position]);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


}


