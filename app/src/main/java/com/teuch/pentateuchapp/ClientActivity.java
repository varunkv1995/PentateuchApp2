package com.teuch.pentateuchapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

/**
 * Created by Md.Saif on 04-01-2018.
 */


import android.content.Intent;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.GridView;


public class ClientActivity extends AppCompatActivity {
    GridView simpleGrid;
    int logos[] = {R.drawable.appex, R.drawable.aptara1, R.drawable.bbmp1, R.drawable.diacritech,
            R.drawable.first_source, R.drawable.hdfc, R.drawable.innodata, R.drawable.linkedin,
            R.drawable.seek, R.drawable.sigmax, R.drawable.thomsan, R.drawable.wexos,R.drawable.stars};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.client1);
        simpleGrid = (GridView) findViewById(R.id.simpleGridView); // init GridView

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), logos);
        simpleGrid.setAdapter(customAdapter);

    }
}