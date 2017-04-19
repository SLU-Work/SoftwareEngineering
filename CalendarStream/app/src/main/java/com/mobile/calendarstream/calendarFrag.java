package com.mobile.calendarstream;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sean on 4/16/2017.
 */

public class calendarFrag extends Fragment {

    MainActivity _activity;


    public calendarFrag(){
    }


    public static calendarFrag newInstance(){
        calendarFrag frag = new calendarFrag();
        return frag;
    }


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View v = inflater.inflate(R.layout.calendar_stream, container, false);

        RecyclerView rv = (RecyclerView)v.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);

        List<card_data> data = new ArrayList<card_data>();

        data.add(new card_data("April 23", "Some Project that's going to crush me", "12:50"));
        data.add(new card_data("April 24", "Some Project that's going to crush me", "12:50"));
        data.add(new card_data("April 25", "Some Project that's going to crush me", "12:50"));
        data.add(new card_data("April 26", "Some Project that's going to crush me", "12:50"));
        data.add(new card_data("April 27", "Some Project that's going to crush me", "12:50"));
        data.add(new card_data("April 29", "Some Project that's going to crush me", "12:50"));
        data.add(new card_data("April 28", "Some Project that's going to crush me", "12:50"));

        RVAdapter adapter = new RVAdapter(data);
        rv.setAdapter(adapter);

        return v;
    }

    public void setActivity(MainActivity activity){ _activity = activity;}
}
