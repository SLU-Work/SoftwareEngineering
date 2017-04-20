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
    private int events_size = 0;


    public card_data(int year, int month, int day){
        this.date = Calendar.getInstance();
        date.set(year,month,day);
        events = new ArrayList<>();
    }

    public void setImg(int url){
        this.imgUrl = url;
    }

    public void setDate(int year, int month, int day, int hour, int minute){
        date = Calendar.getInstance();
        date.set(year,month,day,hour,minute);
    }
    public void setTime(int hour, int minute){
        date.set(Calendar.HOUR, hour);
        date.set(Calendar.MINUTE, minute);
    }
    public void setLabel(String label){
        this.label = label;
    }

    public String getTime(){
        return date.get(Calendar.HOUR)+":"+date.get(Calendar.MINUTE);
    }

    public String getMonthDay(){
        return date.getDisplayName(Calendar.MONTH,SHORT, Locale.US).toUpperCase()+ date.get(Calendar.DAY_OF_MONTH);
    }
    public String getMonth(){
        return date.getDisplayName(Calendar.MONTH,SHORT, Locale.US).toUpperCase();
    }
    public int getDay(){
        return date.get(Calendar.DAY_OF_MONTH);

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

    public void addEvent(String label, int hour, int minute, int url){
        card_data event = new card_data(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
        event.setLabel(label);
        event.setTime(hour, minute);
        event.setImg(url);
        events.add(event);
        events_size++;
        //add event to parent date, but de-initialize the child event's "events" array
        if (events_size == 1){
            event.events = null;
        }
    }
    public List<card_data> getEvents(){
        return events;
    }

    public card_data getEvent(int position){
        if(events_size > position){
            return events.get(position);
        }else {
            return null;
        }
    }
    public boolean hasEvents(){
        if(events_size >0){
            return true;
        }else{
            return false;
        }
    }


}
