package com.teuch.pentateuchapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.teuch.pentateuchapp.R;
import com.teuch.pentateuchapp.adapter.Adapter;
import com.teuch.pentateuchapp.adapter.CustomAdapter;


public class TechnologiesFragment extends Fragment {

 GridView gridView;
  int images[]={R.mipmap.ic_azur,R.mipmap.ic_android3,R.mipmap.ic_fram,R.mipmap.ic_herku,R.mipmap.ic_java,R.mipmap.ic_rfid,R.mipmap.ic_koha,R.mipmap.ic_salescree};

    public TechnologiesFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_technologies, container, false);
         gridView = (GridView) rootview.findViewById(R.id.grid1); // init GridView
        Adapter adapter=new Adapter(getActivity(),images);
        gridView.setAdapter(adapter);
        return rootview;

    }

}