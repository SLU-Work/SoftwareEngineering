package com.slu.se_project.main;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.slu.se_project.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sean on 4/20/2017.
 */

public class subAdapter extends RecyclerView.Adapter<subAdapter.ViewHolder> {

    private List<card_data> data;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView label;
        TextView time;
        ImageView icon;

        ViewHolder(View itemView){
            super(itemView);

            label = (TextView)itemView.findViewById(R.id.label);
            time = (TextView)itemView.findViewById(R.id.time);
            icon = (ImageView)itemView.findViewById(R.id.icon);
        }
    }

    @Override
    public subAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_event, viewGroup, false);
        subAdapter.ViewHolder vh = new subAdapter.ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(subAdapter.ViewHolder ViewHolder, int i) {
        card_data day_events = data.get(i);

        ViewHolder.icon.setImageResource(day_events.getImgUrl());
        ViewHolder.label.setText(day_events.getLabel());
        ViewHolder.time.setText(day_events.getTime());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    subAdapter(List<card_data> data){
        this.data = data;
        Collections.sort(data, new DateComparator());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}

