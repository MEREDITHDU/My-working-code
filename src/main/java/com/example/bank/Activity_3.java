package com.example.bank;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class Activity_3 extends AppCompatActivity {
    private GestureDetectorCompat gestureObject;
    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);


        gestureObject = new GestureDetectorCompat(this, new Activity_3.LearnGesture());
        sound = MediaPlayer.create(Activity_3.this, R.raw.ak21sound);
    }
        @Override
        public boolean onTouchEvent (MotionEvent event){
            this.gestureObject.onTouchEvent(event);
            return super.onTouchEvent(event);
        }


        class LearnGesture extends GestureDetector.SimpleOnGestureListener {
            @Override
            public boolean onFling(MotionEvent event1, MotionEvent event2, float velocity1, float velocity2) {
                if (event2.getX() > event1.getX()) {

                    Intent Intent = new Intent(Activity_3.this, Activity_4.class);
                    startActivity(Intent);
                    finish();
                    sound.start();

                } else if (event2.getX() < event1.getX()) {
                    Intent Intent = new Intent(Activity_3.this, Activity_2.class);
                    startActivity(Intent);
                    finish();
                    sound.start();
                }
                return true;
            }
        }

    }

