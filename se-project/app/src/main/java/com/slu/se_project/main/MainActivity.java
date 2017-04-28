package com.slu.se_project.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.slu.se_project.R;
import com.slu.se_project.navigation.NavigationActivity;

public class MainActivity extends NavigationActivity {

    private Toolbar mNavigationToolbar;
    calendarFrag _calFrag;
    ExploreFrag _exploreFrag;
    PlacesFrag _placesFrag;
    String frag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setupViewHandles() {
        if (_calFrag == null) {
            _calFrag = new calendarFrag();
            _calFrag.setActivity(this);
        }
        if (_exploreFrag == null) {
            _exploreFrag = new ExploreFrag();
            _exploreFrag.setActivity(this);
        }
        if (_placesFrag == null) {
            _placesFrag = new PlacesFrag();
            _placesFrag.setActivity(this);
        }
        setFrag();
    }

    public void setFrag() {
        if (getIntent().hasExtra("Frag")) {
            frag = getIntent().getStringExtra("Frag");
        } else {
            frag = "MY_PLAN";
        }
        FragmentManager fm = getSupportFragmentManager();
        switch (frag) {
            case "EXPLORE":
                fm.beginTransaction().add(R.id.navigation_activity_container, _exploreFrag).commit();
                break;
            case "MY_PLAN":
                fm.beginTransaction().add(R.id.navigation_activity_container, _calFrag).commit();
                break;
            case "MY_PLACES":
                fm.beginTransaction().add(R.id.navigation_activity_container, _placesFrag).commit();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected int getContentResourceId() {
        return R.layout.activity_main;
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

}
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        String btnName = null;
        switch(itemId) {
            case R.id.search:
                btnName = "Search";
                break;
            case R.id.overflow:
                btnName = "Overflow";
                break;
        }
        Snackbar.make(getNavigationDrawer(), "Button " + btnName, Snackbar.LENGTH_LONG).show();
        return true;
    }

*/
/*          @Override
        public void showPopup(View v){
             PopupMenu popup = new PopupMenu(this, v);
             MenuInflater inflater = popup.getMenuInflater();

         }*/
/*
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



*/
