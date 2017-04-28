package com.slu.se_project.userProfile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;

import com.slu.se_project.R;
import com.slu.se_project.navigation.NavigationActivity;

/**
 * Created by bharg on 3/27/2017.
 */

public class UserProfileActivity extends NavigationActivity {

    private Toolbar mNavigationToolbar;
    Profile_Frag _profileFrag;
    Contacts_Frag _contactsFrag;
    String frag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void setupViewHandles() {

        if(_profileFrag == null){
            _profileFrag = new Profile_Frag();
            _profileFrag.setActivity(this);
        }
        if(_contactsFrag == null){
            _contactsFrag = new Contacts_Frag();
            _contactsFrag.setActivity(this);
        }

        frag = getIntent().getStringExtra("Frag");
        FragmentManager fm = getSupportFragmentManager();

        switch (frag){
            case "USER_PROFILE":
                fm.beginTransaction().add(R.id.navigation_activity_container, _profileFrag ).commit();
                break;
            case "USER_CONTACTS":
                fm.beginTransaction().add(R.id.navigation_activity_container, _contactsFrag ).commit();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected int getContentResourceId() {
        return R.layout.activity_profiles;
    }

}
