package com.teuch.pentateuchapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class LoginActivity extends AppCompatActivity {
GridView gridView;
    int image[]={
            R.mipmap.ic_herku, R.mipmap.ic_java, R.mipmap.ic_koha, R.mipmap.ic_net, R.mipmap.ic_salescree, R.mipmap.ic_rfid, R.mipmap.ic_android3, R.mipmap.ic_fram,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        GridView gridView=(GridView)findViewById(R.id.grid1);

        adapter g =new adapter(this,image);
        gridView.setAdapter(g);
    }
}
