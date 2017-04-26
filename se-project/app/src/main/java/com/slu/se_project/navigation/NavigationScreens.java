package com.slu.se_project.navigation;

import android.app.Activity;

import com.slu.se_project.login.reg_Activity;
import com.slu.se_project.main.MainActivity;
import com.slu.se_project.search.SearchActivity;
import com.slu.se_project.settings.SettingsActivity;
import com.slu.se_project.userProfile.UserProfileActivity;

/**
 * Created by bharg on 2/6/2017.
 */

public enum NavigationScreens {
    MY_PLAN(MainActivity.class),
    MY_PLACES(MainActivity.class),
    EXPLORE(MainActivity.class),
    USER_PROFILE(UserProfileActivity.class),
    USER_CONTACTS(UserProfileActivity.class);
    private Class<? extends Activity> mActivity;

    private NavigationScreens(Class<? extends Activity> activity){
        mActivity = activity;
    }

    public Class<? extends Activity> get(){
        return mActivity;
    }
}
