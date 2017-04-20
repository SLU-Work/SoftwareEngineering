package com.slu.se_project.main;

import android.media.Image;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.slu.se_project.R;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static java.util.Calendar.FEBRUARY;
import static java.util.Calendar.SHORT;

/**
 * Created by Sean on 4/16/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private List<card_data> data;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cv;
        TextView date;
        TextView label;
        TextView time;
        ImageView icon;

        ViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            date = (TextView)itemView.findViewById(R.id.date);
            label = (TextView)itemView.findViewById(R.id.label);
            time = (TextView)itemView.findViewById(R.id.time);
            icon = (ImageView)itemView.findViewById(R.id.icon);


        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_date, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(ViewHolder ViewHolder, int i) {
        String d = data.get(i).getMonthDay();
        String t = data.get(i).getTime();
        String ldate;
        if(i > 0){
            ldate = data.get(i-1).getMonthDay();
        }else{
            ldate = null;
        }


        if((data.get(i).getImgUrl() != 0)&&(d.equals(ldate))){
                ViewHolder.date.setVisibility(View.INVISIBLE);
                ViewHolder.icon.setImageResource(data.get(i).getImgUrl());
          //  ViewHolder.icon.setBackground(null);
     /*       ViewHolder.time.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.layout_alignParentLeft
            ));
       */ }else {
            ViewHolder.date.setText(d);
        }
        ViewHolder.label.setText(data.get(i).getLabel());
        ViewHolder.time.setText(t);

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    RVAdapter(List<card_data> data){
        this.data = data;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
