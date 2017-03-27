package com.slu.se_project.navigation;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

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
//    private TextView mNavMenuTitle;
    private DrawerLayout mNavigationDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity_core);


        mNavigationToolbar = (Toolbar)findViewById(R.id.navigation_toolbar);
        mContentContainer = (FrameLayout)findViewById(R.id.navigation_activity_container);
        mNavigationDrawer = (DrawerLayout)findViewById(R.id.drawer_layout);
//        mNavMenuTitle = (TextView) findViewById(R.id.toolbar_title);

        setSupportActionBar(mNavigationToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        if(getContentResourceId()!=0){mContentContainer.addView(getLayoutInflater().inflate(getContentResourceId(),null));}

        mPlanitApplication = PlanitApplication.getInstance();
        mSessionManager  = mPlanitApplication.getSessionManager();
        mResourceManager = mPlanitApplication.getResourceManager();
        mNavigationController = mPlanitApplication.getNavigationController();
        mNavigationController.viewShown(this);

        setupViewHandles();
        setupViewListeners();
    }

//    protected TextView getNavMenuTitle(){return mNavMenuTitle;}

    protected DrawerLayout getNavigationDrawer(){return mNavigationDrawer;}

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

    protected void setupViewListeners() {

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mNavigationDrawer, mNavigationToolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        mNavigationDrawer.addDrawerListener(actionBarDrawerToggle);
    }

    protected abstract int getContentResourceId();

}
