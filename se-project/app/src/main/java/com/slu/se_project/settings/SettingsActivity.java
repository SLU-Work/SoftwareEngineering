package com.slu.se_project.settings;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.slu.se_project.R;
import com.slu.se_project.navigation.NavigationActivity;

/**
 * Created by bharg on 3/29/2017.
 */

public class SettingsActivity extends NavigationActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentResourceId() {
        return R.layout.activity_settings;
    }

}