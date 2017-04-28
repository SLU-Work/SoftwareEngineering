package com.slu.se_project.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import java.util.ArrayList;
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


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View v = inflater.inflate(R.layout.main_calendar, container, false);



        FloatingActionButton fab = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        fab.setImageDrawable(ContextCompat.getDrawable(getContext(),R.drawable.ic_action_add_white));
        fab.setVisibility(View.VISIBLE);

        RecyclerView rv = (RecyclerView)v.findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        rv.setLayoutManager(layoutManager);

        List<card_data> data = new ArrayList<card_data>();

        data.add(new card_data(2017,4,23));
        data.get(0).addEvent("Baseball Game", 19, 50, R.drawable.baseball100);
        data.get(0).addEvent("Some Project that's going to crush me", 12, 50, R.drawable.default_icon);
        data.get(0).addEvent("Pre-game at the bar", 17, 50, R.drawable.cheers100);

        data.add(new card_data(2017,4,25));
        data.get(1).addEvent("Hiking", 14, 50, R.drawable.hiking100);

        data.add(new card_data(2017,4,26));
        data.get(2).addEvent("Piiiiizzzzzaaaa", 17, 50, R.drawable.pizza100);
        data.get(2).addEvent("Some Project that's going to crush me", 12, 50, R.drawable.default_icon);
        data.get(2).addEvent("Hockey", 19, 50, R.drawable.hockey100);

        RVAdapter adapter = new RVAdapter(data, getActivity());
        rv.setAdapter(adapter);

        return v;
    }

    public void setActivity(MainActivity activity){ _activity = activity;}
}


