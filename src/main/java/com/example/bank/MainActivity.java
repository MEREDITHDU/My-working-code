package com.example.bank;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends Activity implements View.OnClickListener {
    //private Button button;
    //private static int SPLASH_TIME_OUT = 4000;

    public static List<Integer> numberList =new ArrayList<Integer>();
    private Button btn_Random,btn_Next;
    public static int countNext=0;

    private GestureDetectorCompat gestureObject;
    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureObject = new GestureDetectorCompat(this, new LearnGesture());
        sound = MediaPlayer.create(MainActivity.this, R.raw.ak21sound);


        btn_Random =(Button) findViewById(R.id.btn_random);
        btn_Next =(Button) findViewById(R.id.btn_next);
        btn_Random.setOnClickListener(this);


        btn_Next.setOnClickListener(this);
//        new Handler().postDelayed(new Runnable(){
//            @Override
//            public void run() {
//                Intent homeIntent= new Intent(MainActivity.this,HomeActivity.class);
//                startActivity(homeIntent);
//                finish();
//            }
//        },SPLASH_TIME_OUT);

//        button=(Button)findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openActivity2();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    public void openActivity2(){
//        Intent intent=new Intent(this, Activity_2.class);
//        startActivity(intent);
//        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
//    }
//
//    @Override
//    public void finish() {
//        super.finish();
//       overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
//    }


        @Override
        public boolean onTouchEvent (MotionEvent event){
            this.gestureObject.onTouchEvent(event);
            return super.onTouchEvent(event);
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_random:

                findRandom();

                break;
            case R.id.btn_next:
                countNext=0;

                System.out.println("first value of array:"+numberList.get(countNext));
                if(numberList.get(countNext)==1){
                    countNext++;
                    startActivity(new Intent(MainActivity.this,Random_Money.class));
                }else if (numberList.get(countNext) == 2) {
                    countNext++;
                    startActivity(new Intent(MainActivity.this,Random_Boom.class));
                }else if (numberList.get(countNext) ==3) {
                    countNext++;
                    startActivity(new Intent(MainActivity.this,Random_guard.class));
                }
                break;
            default:
                break;
        }
    }

    private void findRandom() {
        numberList.clear();
        for (int i = 0; i < 3; i++) {
            numberList.add(i + 1);
        }

        long seed = System.nanoTime();
        Collections.shuffle(numberList, new Random(seed));
        Collections.shuffle(numberList, new Random(seed));


        for (int no : numberList) {
            System.out.println("random number:" + no);
        }
    }

        class LearnGesture extends GestureDetector.SimpleOnGestureListener {
            @Override
            public boolean onFling(MotionEvent event1, MotionEvent event2, float velocity1, float velocity2) {
                if (event2.getX() > event1.getX()) {

                    Intent Intent = new Intent(MainActivity.this, Activity_2.class);
                    startActivity(Intent);
                    finish();

                    sound.start();

                } else if (event2.getX() < event1.getX()) {
                    if (sound.isPlaying()){
                        sound.pause();
                    }
                }
                return true;
            }
        }
    }
