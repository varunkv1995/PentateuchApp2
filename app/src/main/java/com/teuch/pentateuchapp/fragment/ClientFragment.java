package com.teuch.pentateuchapp.fragment;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.teuch.pentateuchapp.R;
import com.teuch.pentateuchapp.adapter.CustomAdapter;


public class ClientFragment extends Fragment {

    GridView simpleGrid;

    int logos[] = {R.drawable.appex, R.drawable.aptara1, R.drawable.bbmp1, R.drawable.diacritech, R.drawable.first_source, R.drawable.wexos, R.drawable.thomsan, R.drawable.sigmax,R.drawable.seek,R.drawable.linkedin,R.drawable.innodata,R.drawable.hdfc};


    public ClientFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_client, container, false);
        simpleGrid = (GridView) rootview.findViewById(R.id.simpleGridView); // init GridView
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), logos);
        simpleGrid.setAdapter(customAdapter);
        return rootview;
    }


}
