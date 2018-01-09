package com.teuch.pentateuchapp.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import com.teuch.pentateuchapp.R;
import com.teuch.pentateuchapp.adapter.HomeAdapter;
import com.teuch.pentateuchapp.fragment.AboutUsFragment;
import com.teuch.pentateuchapp.fragment.ClientFragment;
import com.teuch.pentateuchapp.fragment.ContactFragment;
import com.teuch.pentateuchapp.fragment.HomeFragment;
import com.teuch.pentateuchapp.fragment.ServiceFragment;
import com.teuch.pentateuchapp.fragment.TechnologiesFragment;

import me.relex.circleindicator.CircleIndicator;
public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    private DrawerArrowDrawable drawerArrowDrawable;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle drawerToggle;
    private Toolbar toolbar;
    private int currentIndex = 0;
    private String CURRENT_TAG;
    public static MainActivity mainActivity;
    private Handler handler;
    private com.teuch.pentateuchapp.adapter.PagerAdapter adapter;
    private ViewPager viewPager;
     ImageView imageView;
     private CircleIndicator circleIndicator;
    private ViewPager mpager;
    private HomeAdapter homeAdapter;
    private final String TAG_HOME = "Home";
    private final String TAG_ABOUT = "AboutUs";
    private final String TAG_SERVICE = "Service";
    private final String TAG_CLIENTS = "Clients";
    private final String TAG_TECHNOLOGIES = "Technologies";
    private final String TAG_CONTACT = "Contact";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        toolbar = (Toolbar)findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new com.teuch.pentateuchapp.adapter.PagerAdapter(getSupportFragmentManager());
        adapter.add(new HomeFragment());
        adapter.add(new AboutUsFragment());
        adapter.add(new ServiceFragment());
        adapter.add(new ClientFragment());
        adapter.add(new TechnologiesFragment());
        adapter.add(new ContactFragment());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
        setTitle("Home");

        mainActivity = this;
     //   CURRENT_TAG = TAG_ABOUT;
        handler = new Handler();
      setDrawer();
       // loadFragment(android.R.anim.fade_in,android.R.anim.fade_out,true);
    }
    private void setDrawer() {
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        //toolbar = (Toolbar)findViewById(R.id.tool);
        drawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.opened,R.string.close);
        drawerToggle.setDrawerArrowDrawable(new DrawerArrowDrawable(this));
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
       navigationView = (NavigationView) findViewById(R.id.navigation_view);
       navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        //loadFragment(R.layout.fragment_about_us);
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.menu_About:
                        //loadFragment(R.layout.fragment_about_us);
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.menu_services:
                        //loadFragment(R.layout.fragment_);
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.menu_client:
                        //loadFragment(R.layout.fragment_client);
                        viewPager.setCurrentItem(3);
                        break;
                    case R.id.menu_Technologies:
                        //loadFragment(R.layout.fragment_technologies);
                        viewPager.setCurrentItem(4);
                        break;
                    case R.id.menu_contact:
                        //loadFragment(R.layout.fragment_contact);
                        viewPager.setCurrentItem(5);
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

//    private void loadFragment(final int leftAnim, final int rightAnim, final boolean showAnim) {
//        if(getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null)
//        {
//            drawerLayout.closeDrawers();
//            return;
//        }
//  //      getSupportActionBar().setTitle(CURRENT_TAG);
//        Runnable pendingRunnable = new Runnable() {
//            @Override
//            public void run() {
//                Fragment fragment = getFragment();
//                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                if (showAnim)
//                    fragmentTransaction.setCustomAnimations(leftAnim, rightAnim);
//                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
//                fragmentTransaction.commitAllowingStateLoss();
//            }
//        };
//
//        if(pendingRunnable != null)
//            handler.post(pendingRunnable);
//        invalidateOptionsMenu();
//    }

    public void setTitle(String title)
    {
        toolbar.setTitle(title);
    }



   /* private Fragment getFragment() {
        switch (currentIndex){
            case 0:
                toolbar.setTitle("Home");
                HomeFragment homeFragment=new HomeFragment();
                return homeFragment;
            case 1:
                toolbar.setTitle("About Us");
                AboutUsFragment aboutUsFragment=new AboutUsFragment();
                return aboutUsFragment;
            case 2:
                toolbar.setTitle("Services");
                ServiceFragment serviceFragment=new ServiceFragment();

                return serviceFragment;
            case 3:
                toolbar.setTitle("Clients");
                ClientFragment clientFragment=new ClientFragment();

                return clientFragment;
            case 4:
                toolbar.setTitle("Technologies");
                TechnologiesFragment technologiesFragment=new TechnologiesFragment();

                return technologiesFragment;
            case 5:
                toolbar.setTitle("Contact US");
                ContactFragment contactFragment=new ContactFragment();
                return contactFragment;

        }
        return null;
    }*/
    /*public void loadFragment(int id){
        switch (id){
            case R.layout.fragment_home:
                currentIndex = 0;
                CURRENT_TAG = TAG_HOME;
                break;
            case R.layout.fragment_about_us:
                currentIndex = 1;
                CURRENT_TAG = TAG_ABOUT;
                break;
            case R.layout.fragment_:
                currentIndex = 2;
                CURRENT_TAG = TAG_SERVICE;
                break;
            case R.layout.fragment_client:
                currentIndex = 3;
                CURRENT_TAG = TAG_CLIENTS;
                break;
            case R.layout.fragment_technologies:
                currentIndex = 4;
                CURRENT_TAG = TAG_TECHNOLOGIES;
                break;
            case R.layout.fragment_contact:
                currentIndex = 5;
                CURRENT_TAG = TAG_CONTACT;

        }
        //this.loadFragment(R.anim.anim_fade_in_left,R.anim.anim_fade_out_right,true);
    }*/
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawers();
            return;
        }
        if(currentIndex != 0)
        {
            viewPager.setCurrentItem(0);
           // CURRENT_TAG = TAG_HOME;
            //loadFragment(R.anim.anim_right,R.anim.anim_left,true);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        currentIndex = position;
        switch (position){
            case 0:setTitle("Home");
                break;
            case 1:setTitle("About Us");
                break;
            case 2:setTitle("Services");
                break;
            case 3:setTitle("Client");
                break;
            case 4:setTitle("Technologies");
                break;
            case 5:
                setTitle("Contact Us");
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}




