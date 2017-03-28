package com.slu.se_project.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.slu.se_project.R;
import com.slu.se_project.navigation.NavigationActivity;

/**
 * Created by bharg on 2/16/2017.
 */

public class MainActivity extends NavigationActivity{

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getContentResourceId() {
        return R.layout.activity_main;
    }
}
