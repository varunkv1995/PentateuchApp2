package com.teuch.pentateuchapp;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;



public class NavigationActivity extends AppCompatActivity {
    private DrawerArrowDrawable drawerArrowDrawable;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        toolbar = (Toolbar)findViewById(R.id.tool);
        navigationView = (NavigationView)findViewById(R.id.navigation_view);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.opened,R.string.close);
        drawerToggle.setDrawerArrowDrawable(new DrawerArrowDrawable(this));
        drawerLayout.addDrawerListener(drawerToggle);
    }
}

