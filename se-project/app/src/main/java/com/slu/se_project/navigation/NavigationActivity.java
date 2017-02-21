package com.slu.se_project.navigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;

import com.slu.se_project.PlanitApplication;
import com.slu.se_project.R;
import com.slu.se_project.backend.ResourceManager;
import com.slu.se_project.backend.SessionManager;

/**
 * Created by bharg on 2/6/2017.
 */

public abstract class NavigationActivity extends AppCompatActivity {

    private PlanitApplication mPlanitApplication;
    private SessionManager mSessionManager;
    private ResourceManager mResourceManager;
    private NavigationController mNavigationController;
    private Toolbar mNavigationToolbar;
    private FrameLayout mContentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity_core);


        mNavigationToolbar = (Toolbar)findViewById(R.id.navigation_toolbar);

        setSupportActionBar(mNavigationToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mContentContainer = (FrameLayout)findViewById(R.id.navigation_activity_container);
        if(getContentResourceId()!=0){mContentContainer.addView(getLayoutInflater().inflate(getContentResourceId(),null));}

        mPlanitApplication = PlanitApplication.getInstance();
        mSessionManager  = mPlanitApplication.getSessionManager();
        mResourceManager = mPlanitApplication.getResourceManager();
        mNavigationController = mPlanitApplication.getNavigationController();
        mNavigationController.viewShown(this);

        setupViewHandles();
        setupViewListeners();
    }

    protected SessionManager getSessionManager(){return mSessionManager;}

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlanitApplication.setCurrentActivity(this);
    }

    @Override
    protected void onPause() {
        mPlanitApplication.setCurrentActivity(null);
        super.onPause();
    }

    protected void setupViewHandles() {}

    protected void setupViewListeners() {}

    protected abstract int getContentResourceId();

}
