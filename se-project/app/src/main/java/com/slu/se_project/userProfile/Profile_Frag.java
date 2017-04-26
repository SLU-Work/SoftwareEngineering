package com.slu.se_project.userProfile;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.slu.se_project.R;

/**
 * Created by Sean on 4/16/2017.
 */

public class Profile_Frag extends Fragment {

    UserProfileActivity _activity;


    public Profile_Frag(){
    }


    public static Profile_Frag newInstance(){
        return new Profile_Frag();
    }


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View v = inflater.inflate(R.layout.user_profile, container, false);



        return v;
    }



    public void setActivity(UserProfileActivity activity){ _activity = activity;}
}
