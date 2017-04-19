package com.slu.se_project.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.slu.se_project.R;

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

        data.add(new card_data("Baseball Game" ));
        data.get(0).setDate(2017,4,23,19,50);
        data.get(0).setImg(R.drawable.baseball100);

        data.add(new card_data("Some Project that's going to crush me"));
        data.get(1).setDate(2017,4,23,12,50);

        data.add(new card_data("Pre-game at the bar"));
        data.get(2).setDate(2017,4,23,17,50);
        data.get(2).setImg(R.drawable.cheers100);

        data.add(new card_data("Hiking"));
        data.get(3).setImg(R.drawable.hiking100);
        data.get(3).setDate(2017,4,24,14,50);

        data.add(new card_data("Piiiiizzzzzaaaa"));
        data.get(4).setImg(R.drawable.pizza100);
        data.get(4).setDate(2017,4,24,17,50);


        data.add(new card_data("Some Project that's going to crush me"));
        data.get(5).setDate(2017,4,24,12,50);

        data.add(new card_data("Hockey"));
        data.get(6).setImg(R.drawable.hockey100);
        data.get(6).setDate(2017,4,24,19,50);

        Collections.sort(data, new DateComparator());


        RVAdapter adapter = new RVAdapter(data);
        rv.setAdapter(adapter);

        return v;
    }

    public void setActivity(MainActivity activity){ _activity = activity;}
}


