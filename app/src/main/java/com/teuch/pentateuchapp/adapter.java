package com.teuch.pentateuchapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by varu on 03-01-2018.
 */


public class adapter extends BaseAdapter {
    int images[];

    public adapter(Context context) {
        this.context = context;
    }

    Context context;
    GridView g;
    View view;

    public adapter(Context context, int[] image) {
        this.context = context;
        this.images=image;

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.single_item,null);
            ImageView imageView=(ImageView)convertView.findViewById(R.id.image11);
            imageView.setImageResource(images[position]);


        }
        return convertView;

    }
}
