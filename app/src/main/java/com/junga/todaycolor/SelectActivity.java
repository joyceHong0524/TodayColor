package com.junga.todaycolor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class SelectActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ListInfo> situation_list = new ArrayList<>();
    ArrayList<ListInfo> feeling_list = new ArrayList<>();
    ArrayList<ListInfo> weather_list = new ArrayList<>();
    int selectedList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);



        Intent i = getIntent();
        selectedList = i.getIntExtra("selectedList",100);
        TextView listType = (TextView) findViewById(R.id.list_type);
        listItemset();
        setRecyclerView();



        if(selectedList == MainActivity.SITUATION_SELECTED){
            listType.setText("By Situation");
        }else if (selectedList == MainActivity.FEELING_SELECTED){
            listType.setText("By Emotion");
        }else if (selectedList == MainActivity.WEATHER_SELECTED){
            listType.setText("By Weather");
        }

    }

    private void setRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SelectAdapter adapter;

        if(selectedList == MainActivity.SITUATION_SELECTED){
            adapter = new SelectAdapter(situation_list,this);
        }else if (selectedList == MainActivity.FEELING_SELECTED){
            adapter = new SelectAdapter(feeling_list,this);
        }else if (selectedList == MainActivity.WEATHER_SELECTED){
            adapter = new SelectAdapter(weather_list,this);
        } else{
            adapter = new SelectAdapter(feeling_list,this);
        }





        recyclerView.setAdapter(adapter);

    }



    //list item의 내용은 여기서 바꿔주면 된다.
    //근데 다른 파일로 묶어서 관리하고 싶은데 .. 맵핑..?
    //왜냐면 arraylist.add는 메소드를 실행하는 것 이기때문에 꼭 안에서 해줘야함..흑;

            public void listItemset(){
                situation_list.add(new ListInfo("couple","Going on a first date",Value.RED,getString(R.string.going_date_red),"red_clothes"));
                situation_list.add(new ListInfo("weddingcouple","Going to Wedding",Value.PASTEL,getString(R.string.going_wedding_pastel),"wedding_clothes"));
                situation_list.add(new ListInfo("interview","Going to job interview",Value.BLUE,getString(R.string.going_interview_blue),"interview_clothes"));
                situation_list.add(new ListInfo("tomb","Going to court as the accused",Value.CREAM,getString(R.string.going_court_cream),"cream_clothes"));
                situation_list.add(new ListInfo("mace","Going to funeral",Value.BLACK,getString(R.string.going_funeral_black),"funeral_clothes"));

                feeling_list.add(new ListInfo("attention","When you want attention",Value.RED,getString(R.string.want_attention_red),"red_clothes"));
                feeling_list.add(new ListInfo("stressed","When you are stressed",Value.GREEN,getString(R.string.when_stressed_green),"green_clothes"));
                feeling_list.add(new ListInfo("sad","When you are depressed",Value.YELLOW,getString(R.string.feeling_sad_yellow),"yellow_clothes"));
                feeling_list.add(new ListInfo("energy","When you need a lot of energy",100,getString(R.string.need_energy_pink),"pink_clothes"));
                feeling_list.add(new ListInfo("decision","When you make a decision",Value.PURPLE,getString(R.string.decision_making_purple),"purple_clothes"));

                weather_list.add(new ListInfo("spring","Spring is coming",Value.PASTEL,getString(R.string.spring),"wedding_clothes"));
                weather_list.add(new ListInfo("summer","Summer is coming",Value.ORANGE,getString(R.string.summer),"orange_summer_clothes"));
                weather_list.add(new ListInfo("fall","Fall is coming",Value.BROWN,getString(R.string.fall),"brown_clothes"));
                weather_list.add(new ListInfo("winter","WINTER IS COMING!!",Value.CREAM,getString(R.string.winter),"cream_winter_clothes"));




            }
}
