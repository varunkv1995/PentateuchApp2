package com.teuch.pentateuchapp.adapter;

/**
 * Created by US76 on 03-01-2018.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.teuch.pentateuchapp.R;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int logos[];


    public CustomAdapter(Context applicationContext, int[] logos) {
        this.context = applicationContext;
        this.logos = logos;

    }

    @Override
    public int getCount() {
        return logos.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);



        if (view==null)
        {
         view=   layoutInflater.inflate(R.layout.activity_gridview, null);
            // inflate the layout
            ImageView icon = (ImageView) view.findViewById(R.id.icon); // get the reference of ImageView
            icon.setImageResource(logos[i]);
        }
       // set logo images
        return view;
    }
}
