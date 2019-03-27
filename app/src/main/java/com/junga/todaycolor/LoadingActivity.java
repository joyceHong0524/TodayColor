package com.junga.todaycolor;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;

public class LoadingActivity extends AppCompatActivity {

    ImageView gif;
    TextView saying;
    TextView arthor;


    Saying[] sayings={new Saying("Colors are the smiles of nature.","- Leigh Hunt"),new Saying("Coloring outside the lines is a fine art."," - Kim Nance"),
    new Saying("Colors speak all languages."," - Joseph Addison"),new Saying("Color is the fruit of life."," - Guillaume Apollinaire"),new Saying("All colours will agree in the dark."," - Francis Bacon")};



    class Saying {
        String saying;
        String arthor;

        Saying(String saying, String arthor){
            this.saying = saying;
            this.arthor = arthor;
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        gif = (ImageView) findViewById(R.id.gif);
        saying = (TextView) findViewById(R.id.saying);
        arthor = (TextView) findViewById(R.id.arthor);

        int result = selectSaying();
        saying.setText(sayings[result].saying);
        arthor.setText(sayings[result].arthor);

        selectSaying();
        showSpinner();
        startLoading();
    }

    private int selectSaying(){
        Random random = new Random();
        int result = random.nextInt(sayings.length);

        return result;
    }

    private void showSpinner(){
        Glide.with(this).load(R.drawable.loading_spinner)
                                .into(gif);
    }

    private void startLoading(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },3000);
    }

}
