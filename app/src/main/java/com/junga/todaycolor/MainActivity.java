package com.junga.todaycolor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = this.getClass().getSimpleName();
    public static int SITUATION_SELECTED = 1;
    public static int FEELING_SELECTED = 2;
    public static int WEATHER_SELECTED = 3;


    ViewGroup situation_button;
    ViewGroup feeling_button;
    ViewGroup weather_button;
    ViewGroup day_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);

        situation_button = (ViewGroup) findViewById(R.id.situation);
        feeling_button = (ViewGroup) findViewById(R.id.feeling);
        weather_button = (ViewGroup) findViewById(R.id.weather);
        day_button = (ViewGroup) findViewById(R.id.day);

        situation_button.setOnClickListener(this);
        feeling_button.setOnClickListener(this);
        weather_button.setOnClickListener(this);
        day_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.situation:
                goToSelectAcitivity(SITUATION_SELECTED);
                Log.d(TAG, "onClick: 1");
                break;
            case R.id.feeling:
                goToSelectAcitivity(FEELING_SELECTED);
                Log.d(TAG, "onClick: 2");
                break;
            case R.id.weather:
                goToSelectAcitivity(WEATHER_SELECTED);
                Log.d(TAG, "onClick: 3");
                break;
            case R.id.day:
                Intent intent = new Intent (MainActivity.this, ColorOfThailandStory.class);
                startActivity(intent);
                Log.d(TAG,"moved to color of the day");
                break;

        }
    }

    private void goToSelectAcitivity(int selectedList){
        Intent intent = new Intent(MainActivity.this, SelectActivity.class);
        intent.putExtra("selectedList",selectedList);
        startActivity(intent);
    }



}
