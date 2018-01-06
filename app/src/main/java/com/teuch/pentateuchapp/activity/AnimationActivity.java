package com.teuch.pentateuchapp.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.teuch.pentateuchapp.R;


public class AnimationActivity extends AppCompatActivity {

    ImageView logo;
    TextView textView;
    Animation fromtop,frombottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.anim_activity);
        textView=(TextView)findViewById(R.id.text) ;
        logo=(ImageView)findViewById(R.id.logo);
        fromtop= AnimationUtils.loadAnimation(this,R.anim.fromtop);
        logo.setAnimation(fromtop);
        frombottom=AnimationUtils.loadAnimation(this,R.anim.frombottom);
        textView.setAnimation(frombottom);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(AnimationActivity.this, MainActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, 5000);



    }
}
