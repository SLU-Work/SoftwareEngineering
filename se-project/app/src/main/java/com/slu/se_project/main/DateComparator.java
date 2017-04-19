package com.slu.se_project.main;

import java.util.Comparator;

public class DateComparator implements Comparator<card_data> {
    @Override
    public int compare(card_data a, card_data b){
        return a.date.compareTo(b.date);
    }
}
