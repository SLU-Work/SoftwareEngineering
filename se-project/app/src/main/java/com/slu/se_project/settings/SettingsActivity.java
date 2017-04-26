package com.slu.se_project.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;

import com.slu.se_project.R;
import com.slu.se_project.navigation.NavigationActivity;

/**
 * Created by bharg on 3/29/2017.
 */

public class SettingsActivity extends NavigationActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void setupViewHandles() {

    }


    @Override
    protected int getContentResourceId() {
        return R.layout.activity_settings;
    }

}