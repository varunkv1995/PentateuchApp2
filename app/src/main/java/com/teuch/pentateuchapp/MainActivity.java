package com.teuch.pentateuchapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private DrawerArrowDrawable drawerArrowDrawable;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;
    private int currentIndex = 0;
    private String CURRENT_TAG;
    private MainActivity mainActivity;
    private Handler handler;
    private final String TAG_ABOUT = "AboutUs";
    private final String TAG_SERVICE = "Service";
    private final String TAG_CLIENTS = "Clients";
    private final String TAG_TECHNOLOGIES = "Technologies";
    private final String TAG_CONTACT = "Contact";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        ImageView imageview = (ImageView) findViewById(R.id.profile_image);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.circle);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(), bitmap);
        roundedBitmapDrawable.setCircular(true);
        imageview.setImageDrawable(roundedBitmapDrawable);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        mainActivity = this;
        CURRENT_TAG = TAG_ABOUT;
        handler = new Handler();
        setDrawer();
        loadFragment(android.R.anim.fade_in,android.R.anim.fade_out,true);
    }
    private void setDrawer() {
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.opened,R.string.close);
        drawerToggle.setDrawerArrowDrawable(new DrawerArrowDrawable(this));
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
       navigationView = (NavigationView) findViewById(R.id.navigation_view);
       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        loadFragment(R.layout.fragment_about_us);
                        break;
                    case R.id.menu_services:
                        loadFragment(R.layout.fragment_);
                        break;
                    case R.id.menu_client:
                        loadFragment(R.layout.fragment_client);
                        break;
                    case R.id.menu_Technologies:
                        loadFragment(R.layout.fragment_technologies);
                        break;
                    case R.id.menu_contact:
                        loadFragment(R.layout.fragment_contact);
                        break;

                }
                if (item.isChecked())
                    item.setChecked(false);
                else
                    item.setChecked(true);
                return true;

            }
        });
    }

    private void loadFragment(final int leftAnim, final int rightAnim, final boolean showAnim) {
        if(getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null)
        {
            drawerLayout.closeDrawers();
            return;
        }
        getSupportActionBar().setTitle(CURRENT_TAG);
        Runnable pendingRunnable = new Runnable() {
            @Override
            public void run() {
                Fragment fragment = getFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                if (showAnim)
                    fragmentTransaction.setCustomAnimations(leftAnim, rightAnim);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        if(pendingRunnable != null)
            handler.post(pendingRunnable);
        invalidateOptionsMenu();
    }
    private Fragment getFragment() {
        switch (currentIndex){
            case 0:
                AboutUsFragment aboutUsFragment=new AboutUsFragment();
                return aboutUsFragment;
            case 1:
                ServiceFragment serviceFragment=new ServiceFragment();
                return serviceFragment;
            case 2:
                ClientFragment clientFragment=new ClientFragment();
                return clientFragment;
            case 3:
                TechnologiesFragment technologiesFragment=new TechnologiesFragment();
                return technologiesFragment;
            case 4:
                ContactFragment contactFragment=new ContactFragment();
                return contactFragment;

        }
        return null;
    }
    public void loadFragment(int id){
        switch (id){
            case R.layout.fragment_about_us:
                currentIndex = 1;
                CURRENT_TAG = TAG_ABOUT;
                break;
            case R.layout.fragment_:
                currentIndex = 0;
                CURRENT_TAG = TAG_SERVICE;
                break;
            case R.layout.fragment_client:
                currentIndex = 2;
                CURRENT_TAG = TAG_CLIENTS;
        }
        this.loadFragment(R.anim.anim_fade_in_left,R.anim.anim_fade_out_right,true);
    }
}



