package com.mobile.calendarstream;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

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

        ViewHolder(View itemView){
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            date = (TextView)itemView.findViewById(R.id.date);
            label = (TextView)itemView.findViewById(R.id.label);
            time = (TextView)itemView.findViewById(R.id.time);

        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_basic, viewGroup, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(ViewHolder ViewHolder, int i) {
        ViewHolder.date.setText(data.get(i).date);
        ViewHolder.label.setText(data.get(i).label);
        ViewHolder.time.setText(data.get(i).time);

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
