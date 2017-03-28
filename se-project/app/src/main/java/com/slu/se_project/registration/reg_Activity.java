package com.slu.se_project.registration;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.slu.se_project.main.MainActivity;
import com.slu.se_project.navigation.NavigationActivity;
import com.slu.se_project.R;


/**
 * Created by Sean on 2/28/2017.
 */

public class reg_Activity extends AppCompatActivity{

    reg_welcomeFrag _reg_welcomeFrag;
    reg_UserFrag _regUserFrag;
    reg_PassFrag _regPassFrag;
    reg_Contact _reg_contact;

    private static boolean fragmentsSupported = false;
/*
    private static void checkFragmentsSupported() throws NoClassDefFoundError {
        fragmentsSupported = android.app.Fragment.class != null;
    }


    static{
        try{
            checkFragmentsSupported();
        } catch (NoClassDefFoundError e){
            fragmentsSupported = false;
        }
    }

    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_activity);

        if(_reg_contact == null){
            _reg_contact = new reg_Contact();
        }
        if(_reg_welcomeFrag == null){
            _reg_welcomeFrag = new reg_welcomeFrag();
            _reg_welcomeFrag.setActivity(this);
        }

        if(_regUserFrag == null){
            _regUserFrag = new reg_UserFrag();
            _regUserFrag.setActivity(this);
        }

        if(_regPassFrag == null){
            _regPassFrag = new reg_PassFrag();
            _regPassFrag.setActivity(this);
        }

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.initialactivity, _reg_welcomeFrag).commit();

    }

    public void switchFrag(String newFrag){
        FragmentManager fm = getSupportFragmentManager();

        if(newFrag.equals("reg_User")){
            fm.beginTransaction().replace(R.id.initialactivity, _regUserFrag).commit();
            fm.beginTransaction().remove(_reg_welcomeFrag).commit();
        }
        else if (newFrag.equals("reg_Pass")){
            fm.beginTransaction().replace(R.id.initialactivity, _regPassFrag).commit();
            fm.beginTransaction().remove(_regUserFrag).commit();

        }
    }


}
