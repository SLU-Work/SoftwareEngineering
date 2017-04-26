package com.slu.se_project.backend;

import com.slu.se_project.PlanitApplication;
import com.slu.se_project.R;

public class ResourceManager {

    private static final String TAG = ResourceManager.class.getSimpleName();

    private PlanitApplication mAppInstance;

    public ResourceManager(PlanitApplication application){
        mAppInstance = application;
    }

    public String getString(int stringId){
        return mAppInstance.getResources().getString(stringId);
    }

    public String getBackEndlessAppID(){
        return mAppInstance.getResources().getString(R.string.backendless_ap_id);
    }

    public String getBackendlessAppSecret(){
        return mAppInstance.getResources().getString(R.string.backendless_scret_key);
    }

}
