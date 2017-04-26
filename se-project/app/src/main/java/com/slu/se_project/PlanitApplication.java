package com.slu.se_project;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

import com.slu.se_project.backend.BackEndlessCore;
import com.slu.se_project.backend.ResourceManager;
import com.slu.se_project.backend.SessionManager;
import com.slu.se_project.navigation.NavigationActivity;
import com.slu.se_project.navigation.NavigationController;

/**
 * Created by bharg on 2/6/2017.
 */

public class PlanitApplication extends Application{

    private static PlanitApplication sInstance;



    private static Context sharedContext;
    private NavigationActivity currentActivity;
    private NavigationActivity lastActivity;

    private NavigationController mNavigationController;

    private ResourceManager mResourceManager;
    private SessionManager mSessionManager;


    public static PlanitApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mResourceManager = new ResourceManager(this);
        mSessionManager  = new SessionManager(this);

        sInstance = this;

        sharedContext = this;

        mNavigationController = new NavigationController(this);
        BackEndlessCore.initialize(this);

    }


    public ResourceManager getResourceManager(){
        return mResourceManager;
    }

    public SessionManager getSessionManager(){return mSessionManager;}

    public NavigationController getNavigationController() {
        return mNavigationController;
    }

    public static Context getSharedContext() {
        return sharedContext;
    }

    public static Resources getSharedResources() {
        return sharedContext.getResources();
    }

    public static Drawable getSharedDrawable(int id) {
        return getSharedResources().getDrawable(id);
    }

    public void setCurrentActivity(NavigationActivity activity) {
        currentActivity = activity;
        if (activity != null) {
            lastActivity = activity;
        }
    }

    public NavigationActivity getCurrentActivity() {
        return currentActivity;
    }


}
