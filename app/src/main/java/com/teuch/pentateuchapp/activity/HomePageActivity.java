package com.teuch.pentateuchapp.activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ImageView;



import com.teuch.pentateuchapp.adapter.HomeAdapter;

import java.util.Timer;
import java.util.TimerTask;

import com.teuch.pentateuchapp.R;
import me.relex.circleindicator.CircleIndicator;

public class HomePageActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {


    ImageView imageView;


    private CircleIndicator circleIndicator;

    private ViewPager mpager;


    //this is for activity
    private int[] layouts = {R.layout.home_about, R.layout.home_services, R.layout.home_client, R.layout.home_technology, R.layout.home_contact};
    private HomeAdapter homeAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_front_activity);

        mpager = (ViewPager) findViewById(R.id.viewPager);
        homeAdapter = new HomeAdapter(layouts, this);
        mpager.setAdapter(homeAdapter);


        //this is for time picker
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimeTask(), 3000, 8000);


        //this is for logo design
        ImageView imageView = (ImageView) findViewById(R.id.ImageView);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pentateuchlogo);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);


        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.ic_demo);
        indicator.setViewPager(mpager);


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


    private class MyTimeTask extends TimerTask {
        @Override
        public void run() {
            HomePageActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mpager.getCurrentItem() == 0) {
                        mpager.setCurrentItem(1);
                    } else if (mpager.getCurrentItem() == 1) {
                        mpager.setCurrentItem(2);
                    } else if (mpager.getCurrentItem() == 2) {
                        mpager.setCurrentItem(3);
                    } else if (mpager.getCurrentItem() == 3) {
                        mpager.setCurrentItem(4);

                    } else {
                        mpager.setCurrentItem(0);


                    }
                }
            });
        }
    }
}

