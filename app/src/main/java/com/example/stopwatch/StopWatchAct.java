package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchAct extends AppCompatActivity {
    Button btnstart,btnstop;
    ImageView arrowimage;
    Animation round;
    Chronometer timer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        btnstart=findViewById(R.id.btn2);
        btnstop=findViewById(R.id.btn3);
        arrowimage=findViewById(R.id.imageArrow);
        timer1=findViewById(R.id.timer);
//        create optional animation (setalpha(0) means btnstop nhi dikhega jab tak setalpha(1) nhi set karoge)
        btnstop.setAlpha(0);
//        load animation
        round= AnimationUtils.loadAnimation(this,R.anim.rotation);
        Typeface MMedium=Typeface.createFromAsset(getAssets(),"fonts/MMedium.ttf");
        btnstart.setTypeface(MMedium);
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                passing animation on the arrowImage when start button click
                arrowimage.startAnimation(round);
                btnstop.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstart.animate().alpha(0).setDuration(300).start();
                timer1.setBase(SystemClock.elapsedRealtime());
                timer1.start();
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(StopWatchAct.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

    }
}