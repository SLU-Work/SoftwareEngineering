package com.slu.se_project.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.slu.se_project.R;
import com.slu.se_project.navigation.NavigationActivity;

/**
 * Created by bharg on 2/16/2017.
 */

public class MainActivity extends NavigationActivity{

    private Toolbar mNavigationToolbar;
    private FrameLayout mContentContainer;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_activity_core);


        mNavigationToolbar = (Toolbar) findViewById(R.id.navigation_toolbar);
        mContentContainer = (FrameLayout) findViewById(R.id.navigation_activity_container);

        setSupportActionBar(mNavigationToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mContentContainer.addView(getLayoutInflater().inflate(R.layout.activity_main, null));

        setupViewListeners();

    }

    @Override
    protected int getContentResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupViewListeners(){
        super.setupViewListeners();
    }


}
