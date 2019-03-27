package com.junga.todaycolor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected2);

        //View 정의
        TextView colorName= (TextView) findViewById(R.id.color_name);
        TextView description_view = (TextView) findViewById(R.id.description);
        CircleImageView image = (CircleImageView) findViewById(R.id.image);
        ImageView result_background = (ImageView) findViewById(R.id.result_background);

        // Loading 화면 잠시 보여주기
        Intent intent = new Intent(ResultActivity.this, LoadingActivity.class);
        startActivity(intent);

        //건너온 컬러 값,정보 값 받기
        Intent thisIntent = getIntent();
        int colorCode = thisIntent.getIntExtra("Color",0); //don't forget to give a default value everytime!
        String description_text = thisIntent.getStringExtra("Description");
        String resultImageName = thisIntent.getStringExtra("ResultImage");

        image.setImageResource(getApplicationContext().getResources().getIdentifier(resultImageName, "drawable", getApplicationContext().getPackageName()));

        //받은 컬러 값으로 내용 채우기
        if(colorCode == Value.RED){
            colorName.setText(R.string.red);
            result_background.setBackgroundResource(R.drawable.red_background);
        }else if(colorCode == Value.YELLOW){
            colorName.setText(R.string.yellow);
            result_background.setBackgroundResource(R.drawable.yellow_background);
        }else if(colorCode == Value.BLUE){
            colorName.setText(R.string.blue);
            result_background.setBackgroundResource(R.drawable.blue_background);
        }else if(colorCode == Value.PASTEL){
            colorName.setText(R.string.pastel);
            result_background.setBackgroundResource(R.drawable.loading_background); //loading background is kinda pastel.
        }else if(colorCode == Value.BLACK){
            colorName.setText(R.string.black);
            result_background.setBackgroundResource(R.drawable.black_background);
        }else if(colorCode == Value.CREAM) {
            colorName.setText(R.string.cream);
            result_background.setBackgroundResource(R.drawable.cream_background);
        }else if(colorCode == Value.GREEN) {
            colorName.setText(R.string.green);
            result_background.setBackgroundResource(R.drawable.green_background);
        }else if(colorCode == Value.PINK) {
            colorName.setText(R.string.pink);
            result_background.setBackgroundResource(R.drawable.pink_background);
        }else if(colorCode == Value.PURPLE) {
            colorName.setText(R.string.purple);
            result_background.setBackgroundResource(R.drawable.purple_background);
        }else if(colorCode == Value.BROWN) {
            colorName.setText(R.string.brown);
            result_background.setBackgroundResource(R.drawable.brown_background);
        }else if(colorCode == Value.ORANGE) {
            colorName.setText(R.string.orange);
            result_background.setBackgroundResource(R.drawable.orange_background);
        }else{
            colorName.setText(R.string.cream);
            result_background.setBackgroundResource(R.drawable.green_background);
        }


        description_view.setText(description_text);

        //메인화면으로 가는 버튼
        Button button = (Button) findViewById(R.id.back_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }

    @Override
    public void onClick(View v) {

    }
}
