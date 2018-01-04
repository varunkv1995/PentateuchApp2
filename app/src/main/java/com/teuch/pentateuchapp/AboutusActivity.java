package com.teuch.pentateuchapp;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.teuch.pentateuch.R;
import com.teuch.pentateuch.fragment.AdminFragment;
import com.teuch.pentateuch.fragment.ParticipateFragment;

public class AboutUsActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
    }

    private int currentIndex = 0;
    public static AboutUsActivity cur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        cur = this;
        loadFragment(currentIndex);
    }

    public void loadFragment(final int index) {
        currentIndex = index;
        getSupportActionBar().setTitle(getCurrentTitle());
        Runnable penddingLoad = new Runnable() {
            @Override
            public void run() {
                Fragment fragment = getFragment(index);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.anim_left,R.anim.anim_right);
                fragmentTransaction.replace(R.id.frame,fragment);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };
        new Handler().post(penddingLoad);
        invalidateOptionsMenu();
    }

    private String getCurrentTitle() {
        switch (currentIndex){
            case 0:return "Admin";
            case 1:return "Participant";
            case 2:return "Faculty";
        }
        return "";
    }

    private Fragment getFragment(int index) {
        switch (index){
            case 0:return new AdminFragment();
            case 1:return new ParticipateFragment();
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        if(currentIndex != 0) {
            loadFragment(0);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int index = item.getItemId();
        switch (index){
            case R.id.logout_admin:
                //
                loadFragment(0);
                break;
            case R.id.itm2:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
