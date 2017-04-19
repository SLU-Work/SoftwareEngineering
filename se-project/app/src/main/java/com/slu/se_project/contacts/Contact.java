package com.slu.se_project.contacts;

import android.app.Fragment;
import android.database.Cursor;
import android.database.DatabaseUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Sean on 3/6/2017.
 */

public class Contact {
    public int icon;
    public Integer id;
    public String contact_name_first;
    public String contact_name_last;
    public String email;
    public String phone;
    public Map<String, Object> properties;

    public Contact(){
        super();
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public void setContact(Integer primary_key, String first, String last, String email, String phone){
        this.id = primary_key;
        this.contact_name_first = first;
        this.contact_name_last = last;
        this.email = email;
        this.phone = phone;
    }
}

