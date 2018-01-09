package com.teuch.pentateuchapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.teuch.pentateuchapp.R;

/**
 * Created by varu on 03-01-2018.
 */


public class Adapter extends BaseAdapter {
    int images[];

  Context context;
  public Adapter(Context context, int[] image) {
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


        if(convertView==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            convertView=layoutInflater.inflate(R.layout.single_item,null);
            ImageView imageView=(ImageView)convertView.findViewById(R.id.image11);
            imageView.setImageResource(images[position]);


        }
        return convertView;

    }
}
