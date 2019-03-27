package com.junga.todaycolor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class DateResultActivity extends AppCompatActivity {
    CircleImageView god_image;
    TextView date;
    TextView god_name;
    TextView lucky_text;
    TextView unlucky_text;
    ImageView lucky_image;
    ImageView unlucky_image;

    Button back_button;

    int dayNum; // sun= 1  ~ sat = 7


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_date);

        god_image =(CircleImageView) findViewById(R.id.god_image);
        date = (TextView) findViewById(R.id.date);
        god_name = (TextView) findViewById(R.id.god_name);
        lucky_text = (TextView) findViewById(R.id.lucky_color_text);
        unlucky_text = (TextView) findViewById(R.id.unlucky_color_text);


        lucky_image = (ImageView) findViewById(R.id.lucky_color_image);
        unlucky_image = (ImageView) findViewById(R.id.unlucky_color_image);

        dayNum = getDate(); //set the date
        setView(dayNum); //pass the date to set the view

        //go back to the main activity button
        back_button = (Button) findViewById(R.id.back_button);
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(DateResultActivity.this, MainActivity.class);
                startActivity(a);
            }
        });

    }

    private int getDate() {
        Calendar cal = Calendar.getInstance();

        return cal.get(Calendar.DAY_OF_WEEK);
    }

    private void setView(int dayNum){
        switch (dayNum){
            case 1:
                Glide.with(this).load(R.drawable.sunday).into(god_image);
                date.setText("Sunday");
                god_name.setText("Surya");
                lucky_text.setText("Red");
                unlucky_text.setText("blue");
                Glide.with(this).load(R.drawable.red_background).into(lucky_image);
                Glide.with(this).load(R.drawable.blue_background).into(unlucky_image);
                break;
            case 2:
                Glide.with(this).load(R.drawable.monday).into(god_image);
                date.setText("Monday");
                god_name.setText("Chandra");
                lucky_text.setText("Yellow");
                unlucky_text.setText("red");
                Glide.with(this).load(R.drawable.yellow_background).into(lucky_image);
                Glide.with(this).load(R.drawable.red_background).into(unlucky_image);
                break;
            case 3:
                Glide.with(this).load(R.drawable.tuesday).into(god_image);
                date.setText("Tuesday");
                god_name.setText("Mangala");
                lucky_text.setText("Pink");
                unlucky_text.setText("Yellow");
                Glide.with(this).load(R.drawable.pink_background).into(lucky_image);
                Glide.with(this).load(R.drawable.yellow_background).into(unlucky_image);
                break;
            case 4:

                Glide.with(this).load(R.drawable.wednesday).into(god_image);
                date.setText("Wednesday");
                god_name.setText("Budha");
                lucky_text.setText("Green");
                unlucky_text.setText("Pink");
                Glide.with(this).load(R.drawable.green_background).into(lucky_image);
                Glide.with(this).load(R.drawable.pink_background).into(unlucky_image);
                break;
            case 5:
                Glide.with(this).load(R.drawable.thursday).into(god_image);
                date.setText("Thursday");
                god_name.setText("Brihaspati");
                lucky_text.setText("Orange");
                unlucky_text.setText("Purple");
                Glide.with(this).load(R.drawable.orange_background).into(lucky_image);
                Glide.with(this).load(R.drawable.purple_background).into(unlucky_image);
                break;
            case 6:
                Glide.with(this).load(R.drawable.friday).into(god_image);
                date.setText("Friday");
                god_name.setText("Shukra");
                lucky_text.setText("aqua");
                unlucky_text.setText("black");
                Glide.with(this).load(R.drawable.blue_background).into(lucky_image);
                Glide.with(this).load(R.drawable.black_background).into(unlucky_image);
                break;
            case 7:
                Glide.with(this).load(R.drawable.saturday).into(god_image);
                date.setText("Saturday");
                god_name.setText("Shani");
                lucky_text.setText("black");
                unlucky_text.setText("green");
                Glide.with(this).load(R.drawable.black_background).into(lucky_image);
                Glide.with(this).load(R.drawable.green_background).into(unlucky_image);
                break;
        }
    }
}
