package com.teuch.pentateuchapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    ImageView logo;
    TextView textView;
    Animation fromtop,frombottom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        textView=(TextView)findViewById(R.id.text) ;
        logo=(ImageView)findViewById(R.id.logo);
        fromtop= AnimationUtils.loadAnimation(this,R.anim.fromtop);
        logo.setAnimation(fromtop);
        frombottom=AnimationUtils.loadAnimation(this,R.anim.frombottom);
        textView.setAnimation(frombottom);

    }
}
