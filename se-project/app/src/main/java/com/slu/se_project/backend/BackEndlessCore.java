package com.slu.se_project.backend;

import android.content.Context;

import com.backendless.Backendless;
import com.slu.se_project.PlanitApplication;
import com.slu.se_project.R;

public class BackEndlessCore {

    private final static String TAG = BackEndlessCore.class.getName();

    private static BackEndlessCore sInstance;
    private static Context sContext;
    private static boolean isInitialized = false;

    public static void initialize(PlanitApplication application){
        if(!isInitialized){
            isInitialized = true;
            sContext = application;
            sInstance = new BackEndlessCore();
            Backendless.initApp(application,application.getResourceManager().getBackEndlessAppID(),application.getResourceManager().getBackendlessAppSecret(), application.getResourceManager().getString(R.string.app_version));
        }
    }

    public static BackEndlessCore getsInstance(){
        if(!isInitialized){throw new RuntimeException(TAG + "" + " has not been initialized.");}
        return  sInstance;
    }

    private BackEndlessCore(){};

}
