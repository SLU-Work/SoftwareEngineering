package com.slu.se_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.slu.se_project.backend.ResourceManager;
import com.slu.se_project.navigation.NavigationController;

/**
 * Created by bharg on 2/6/2017.
 */

public class PlanitActivity extends AppCompatActivity {

    private PlanitApplication mKollabstrApplication;

    private ServiceManager mServiceManager;
    private SessionManager mSessionManager;
    private ResourceManager mResourceManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnswersManager.reportContentView(this);
        mKollabstrApplication = (KollabstrApplication)getAppInstance();
        mServiceManager  = mKollabstrApplication.getServiceManager();
        mSessionManager  = mKollabstrApplication.getSessionManager();
        mResourceManager = mKollabstrApplication.getResourceManager();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    protected void onResume() {
        super.onResume();
        mNavigationController.viewShown(this);
        application.setCurrentActivity(this);
    }

    @Override
    protected void onPause() {
        application.setCurrentActivity(null);
        super.onPause();
    }

}
