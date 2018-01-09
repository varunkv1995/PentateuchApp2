package com.teuch.pentateuchapp.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.teuch.pentateuchapp.R;
import com.teuch.pentateuchapp.activity.MainActivity;
import com.teuch.pentateuchapp.adapter.HomeAdapter;

import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;


public class HomeFragment extends Fragment {
    private int[] layouts = {R.layout.home_about, R.layout.home_services, R.layout.home_client, R.layout.home_technology, R.layout.home_contact};
   private  ViewPager viewPager;
    private HomeAdapter homeAdapter;
    private View rootView;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView= inflater.inflate(R.layout.fragment_home, container, false);
        viewPager = (ViewPager) rootView.findViewById(R.id.viewp);
        homeAdapter = new HomeAdapter(layouts, rootView.getContext());
        viewPager.setAdapter(homeAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimer(), 5000, 8000);

        ImageView imageView = (ImageView) rootView.findViewById(R.id.ImageView);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pentateuchlogo1);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageView.setImageDrawable(roundedBitmapDrawable);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.pentateuchtechnologies.com/"));
                startActivity(intent);
            }
        });

        CircleIndicator indicator = (CircleIndicator) rootView.findViewById(R.id.ic_demo);
        indicator.setViewPager(viewPager);

        return rootView;
    }

    private class MyTimer extends TimerTask{

        @Override
        public void run() {
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPager.getCurrentItem() == 0) {
                        viewPager.setCurrentItem(1);
                    } else if (viewPager.getCurrentItem() == 1) {
                        viewPager.setCurrentItem(2);
                    } else if (viewPager.getCurrentItem() == 2) {
                        viewPager.setCurrentItem(3);
                    } else if (viewPager.getCurrentItem() == 3) {
                        viewPager.setCurrentItem(4);

                    } else {
                        viewPager.setCurrentItem(0);


                    }
                }
            });
        }
    }
}




