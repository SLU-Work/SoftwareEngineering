package com.slu.se_project.navigation;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.slu.se_project.PlanitApplication;
import com.slu.se_project.R;
import com.slu.se_project.backend.ResourceManager;
import com.slu.se_project.backend.SessionManager;

/**
 * Created by bharg on 2/6/2017.
 */

public abstract class NavigationActivity extends AppCompatActivity{

    private PlanitApplication mPlanitApplication;
    private SessionManager mSessionManager;
    private ResourceManager mResourceManager;
    private NavigationController mNavigationController;
    private Toolbar mNavigationToolbar;
    private FrameLayout mContentContainer;
    private DrawerLayout mNavigationDrawer;
    private ActionBarDrawerToggle mNavigationDrawerToggle;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity_core);


        mNavigationToolbar = (Toolbar)findViewById(R.id.navigation_toolbar);
        mContentContainer = (FrameLayout)findViewById(R.id.navigation_activity_container);
        mNavigationDrawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);

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
        setupNavigationDrawer();
        setupViewListeners();
    }



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

        Log.d("NAVIGATION", "Setup view Listeners");
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

    protected void setupNavigationDrawer() {
        Log.d("NAVIGATION", "Setup navigation drawer");
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                mNavigationDrawer.closeDrawer(GravityCompat.START);
                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_profile:
                        Log.d("NAVIGATION", "Profile Option Selected");
                        mNavigationController.showView(NavigationScreens.USER_PROFILE_VIEW);
                        break;
                    case R.id.nav_search:
                        Log.d("NAVIGATION", "Search Option Selected");
                        mNavigationController.showView(NavigationScreens.SEARCH_VIEW);
                        break;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                return true;
            }
        });

    }

    protected abstract int getContentResourceId();

}
