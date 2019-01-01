package com.example.bank;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Activity_2 extends AppCompatActivity {
    //private Button button;

    private GestureDetectorCompat gestureObject;
    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);


//        button=(Button) findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openActivity3();
//            }
//        });

        gestureObject = new GestureDetectorCompat(this, new Activity_2.LearnGesture());
        sound = MediaPlayer.create(Activity_2.this, R.raw.ak21sound);
    }

    @Override
    public boolean onTouchEvent (MotionEvent event){
        this.gestureObject.onTouchEvent(event);
        return super.onTouchEvent(event);
    }


    class LearnGesture extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float velocity1, float velocity2) {
            if (event2.getX() >event1.getX()) {

                Intent Intent = new Intent(Activity_2.this, Activity_3.class);
                startActivity(Intent);
                finish();

                sound.start();
//                if (sound.isPlaying()){
//                    sound.pause();
//                }

            } else if (event2.getX() < event1.getX()) {
                Intent Intent = new Intent(Activity_2.this, MainActivity.class);
                startActivity(Intent);
                finish();

                sound.start();
            }
            return true;
        }

    }


//    public void openActivity3(){
//        Intent intent=new Intent(this, Activity_3.class);
//        startActivity(intent);
//    }
}
