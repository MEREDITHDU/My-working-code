package com.example.bank;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Random_Money extends Activity implements View.OnClickListener {
    public static List<Integer> numberList =new ArrayList<Integer>();
    private Button btn_Random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_money);

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

                System.out.println("first value of array:" + MainActivity.numberList.get(MainActivity.countNext));
                if (MainActivity.numberList.get(MainActivity.countNext) == 1) {
                    MainActivity.countNext++;
                    startActivity(new Intent(Random_Money.this, Random_Money.class));
                } else if (MainActivity.numberList.get(MainActivity.countNext) == 2) {
                    MainActivity.countNext++;
                    startActivity(new Intent(Random_Money.this, Random_Boom.class));
                } else if (MainActivity.numberList.get(MainActivity.countNext) == 3) {
                    MainActivity.countNext++;
                    startActivity(new Intent(Random_Money.this, Random_guard.class));
                }


                break;

            default:
                break;
        }
    }
}
