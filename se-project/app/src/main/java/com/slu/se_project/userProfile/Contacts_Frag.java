package com.slu.se_project.userProfile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slu.se_project.R;

/**
 * Created by Sean on 4/23/2017.
 */

public class Contacts_Frag extends Fragment{
    UserProfileActivity _activity;


    public Contacts_Frag(){
    }


    public static Contacts_Frag newInstance(){
        return new Contacts_Frag();
    }


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View v = inflater.inflate(R.layout.user_contacts, container, false);



        return v;
    }



    public void setActivity(UserProfileActivity activity){ _activity = activity;}
}
