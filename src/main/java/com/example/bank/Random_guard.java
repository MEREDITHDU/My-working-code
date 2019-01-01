package com.example.bank;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Random_guard extends AppCompatActivity implements View.OnClickListener {
    private Button btn_Random;
    public static int countNext=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_guard);
        // set resources
        btn_Random =(Button) findViewById(R.id.btn_random);
        btn_Random.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_random:


                System.out.println("first value of array:"+MainActivity.numberList.get(countNext));
                if(MainActivity.numberList.get(countNext)==1){
                    MainActivity.countNext++;
                    startActivity(new Intent(Random_guard.this,Random_Money.class));
                }else if (MainActivity.numberList.get(countNext) == 2) {
                    MainActivity.countNext++;
                    startActivity(new Intent(Random_guard.this,Random_Boom.class));
                }else if (MainActivity.numberList.get(countNext) ==3) {
                    MainActivity.countNext++;
                    startActivity(new Intent(Random_guard.this,Random_guard.class));
                }

                countNext++;
                break;

            default:
                break;
        }

    }
}
