package com.slu.se_project;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;

import com.slu.se_project.backend.BackEndlessCore;
import com.slu.se_project.backend.ResourceManager;
import com.slu.se_project.navigation.NavigationController;

/**
 * Created by bharg on 2/6/2017.
 */

public class PlanitApplication extends Application{

    private static PlanitApplication sInstance;



    private static Context sharedContext;
    private PlanitActivity currentActivity;
    private PlanitActivity lastActivity;

    private NavigationController mNavigationController;
    private ResourceManager mResourceManager;

//    private LoginManager loginManager = null;


    public static PlanitApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mResourceManager = new ResourceManager(this);
        sInstance = this;

        sharedContext = this;

        mNavigationController = new NavigationController(this);
        BackEndlessCore.initialize(this);

    }

//    public LoginManager getLoginManager() {
//        if(loginManager == null) {
//            loginManager = new LoginManager(new LoginModel(this), NetworkKt.network(new SharedPrefsBase(this)));
//        }
//        return loginManager;
//    }

    public ResourceManager getResourceManager(){
        return mResourceManager;
    }

    protected SessionManager getSessionManager(){return mSessionManager;}

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

    public void setCurrentActivity(PlanitActivity activity) {
        currentActivity = activity;
        if (activity != null) {
            lastActivity = activity;
        }
    }

    public PlanitActivity getCurrentActivity() {
        return currentActivity;
    }


}
