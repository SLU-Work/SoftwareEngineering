package com.slu.se_project.main;

import java.util.Calendar;

/**
 * Created by Sean on 4/16/2017.
 */

public class card_data {

    public int imgUrl = 0;
    public Calendar date;
    public String label;


    public card_data(Calendar date, String label){
        this.date = date;
        this.label = label;
    }
    public card_data(String label){
        this.label =label;
    }

    public void setImg(int url){
        this.imgUrl = url;
    }

    public void setDate(int year, int month, int day, int hour, int minute){
        date = Calendar.getInstance();
        date.set(year,month,day,hour,minute);
    }

}
