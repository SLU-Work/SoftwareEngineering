package com.slu.se_project.search;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.slu.se_project.R;
import com.slu.se_project.navigation.NavigationActivity;

/**
 * Created by bharg on 3/29/2017.
 */

public class SearchActivity extends NavigationActivity {

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {

        handleIntent(intent);
    }
    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            //use the query to search your data somehow
        }
    }

    @Override
    protected int getContentResourceId() {
        return R.layout.activity_search;
    }

}