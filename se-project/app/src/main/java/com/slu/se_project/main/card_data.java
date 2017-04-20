package com.slu.se_project.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static java.util.Calendar.SHORT;

/**
 * Created by Sean on 4/16/2017.
 */

public class card_data {

    private int imgUrl = 0;
    private Calendar date;
    private String label;
    private List<card_data> events;


    public card_data(Calendar date, String label){
        this.date = date;
        this.label = label;
        events = new ArrayList<>();
    }
    public card_data(String label){
        this.label =label;
        events = new ArrayList<>();
    }

    public void setImg(int url){
        this.imgUrl = url;
    }

    public void setDate(int year, int month, int day, int hour, int minute){
        date = Calendar.getInstance();
        date.set(year,month,day,hour,minute);
    }

    public String getTime(){
        return date.get(Calendar.HOUR)+":"+date.get(Calendar.MINUTE);
    }

    public String getMonthDay(){
        return date.getDisplayName(Calendar.MONTH,SHORT, Locale.US).toUpperCase()+ date.get(Calendar.DAY_OF_MONTH);
    }
    public String getLabel(){
        return label;
    }
    public int getImgUrl(){
        return imgUrl;
    }
    public Calendar getDate(){
        return date;
    }

    public void addEvent(card_data event){
        events.add(event);
        //add event to parent date, but de-initialize the child event's "events" array
        if (events.size() > 1){
            event.events = null;
        }
    }

}
