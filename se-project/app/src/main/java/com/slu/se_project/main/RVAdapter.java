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

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sean on 4/16/2017.
 */

public class RVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<card_data> data;
    private Context context;
    private final int HAS_EVENTS = 1, NO_EVENTS = 0;

    public class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerView rv_events;
        CardView cv;
        TextView date;


        ViewHolder(View itemView){
            super(itemView);

            rv_events = (RecyclerView) itemView.findViewById(R.id.rv_events);
            cv = (CardView)itemView.findViewById(R.id.cv);
            date = (TextView)itemView.findViewById(R.id.month);

        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder{
        TextView date;
        ViewHolder2(View itemView){
            super(itemView);
            date = (TextView)itemView.findViewById(R.id.month);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder vh;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch(viewType) {
            case HAS_EVENTS:
                View v = inflater.inflate(R.layout.card_with_events, viewGroup, false);
                vh = new RVAdapter.ViewHolder(v);
                break;
            default:
                View v2 = inflater.inflate(R.layout.card_default, viewGroup, false);
                vh = new RVAdapter.ViewHolder2(v2);
                break;
        }

        return vh;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder vh, int i) {
        card_data day_events = data.get(i);
        String d = day_events.getMonthDay();
        switch(vh.getItemViewType()){
            case HAS_EVENTS:
                ViewHolder vh1 = (ViewHolder) vh;
                initsubLM(vh1.rv_events, day_events.getEvents());
                vh1.date.setText(d);
                break;
            default:
                ViewHolder2 vh2 = (ViewHolder2) vh;
                vh2.date.setText(d);
                break;
        }

    }


    private void initsubLM(RecyclerView rv_events, List<card_data> subData){
        LinearLayoutManager lm = new LinearLayoutManager(context);
        rv_events.setLayoutManager(lm);
        subAdapter subAdapter = new subAdapter(subData);
        rv_events.setAdapter(subAdapter);
    }

    public int getItemViewType(int position){
        if(data.get(position).hasEvents()){
            return HAS_EVENTS;
        }else{
            return NO_EVENTS;
        }
    }



    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    RVAdapter(List<card_data> data, Context context){
        this.data = data;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
