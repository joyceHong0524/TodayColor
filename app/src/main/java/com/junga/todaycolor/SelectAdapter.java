package com.junga.todaycolor;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class SelectAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<ListInfo> listInfos;
    Context context;


    SelectAdapter(ArrayList<ListInfo> listInfos, Context context) {
        this.listInfos = listInfos;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_select,parent,false);
        return new mViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ListInfo info = listInfos.get(position);
            mViewHolder holder1 = (mViewHolder) holder;

            final int color = info.color;
            final String description = info.description;
            final String image = info.image;
            final String resultImage = info.resultImage;

            holder1.title.setText(info.title);


            final String imageName = info.image;

        holder1.image.setImageResource(context.getResources().getIdentifier(imageName, "drawable", context.getPackageName()));


            holder1.parent_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showResult(color,description,resultImage);
                }
            });

    }

    @Override
    public int getItemCount() {
        return listInfos.size();
    }

    public static class mViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        CardView parent_layout;


        public mViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.select_image);
            this.title = itemView.findViewById(R.id.title);
            this.parent_layout=  itemView.findViewById(R.id.parent_layout);
        }
    }

    void showResult(int color,String description,String resultImage){
        Intent intent = new Intent(context, ResultActivity.class);
        intent.putExtra("Color",color);
        intent.putExtra("Description",description);
        intent.putExtra("ResultImage",resultImage);


        startActivity(context,intent,null);
    }
}
