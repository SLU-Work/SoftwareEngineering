package com.slu.se_project.main;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.slu.se_project.R;
import com.slu.se_project.navigation.NavigationActivity;

public class MainActivity extends NavigationActivity {

    private Toolbar mNavigationToolbar;
    calendarFrag _calFrag;
    ExploreFrag _exploreFrag;
    PlacesFrag _placesFrag;
    String frag;
    private MenuItem mSearchAction;
    private boolean isSearchOpened = false;
    private EditText editSearch;
    SearchView searchView;


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
                handleMenuSearch();
                break;
            case R.id.overflow:
                btnName = "Overflow";
                break;
        }
        Snackbar.make(getNavigationDrawer(), "Button " + btnName, Snackbar.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }

    protected void handleMenuSearch(){
        ActionBar action = getSupportActionBar(); //get the actionbar

        if(isSearchOpened){ //test if the search is open

            //hides the keyboard
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editSearch.getWindowToken(), 0);

            action.setDisplayShowCustomEnabled(false); //disable a custom view inside the actionbar
            action.setDisplayShowTitleEnabled(true); //show the title in the action bar
            //add the search icon in the action bar
            mSearchAction.setIcon(R.drawable.ic_search_white_24dp);
            isSearchOpened = false;
        } else { //open the search entry

            action.setDisplayShowCustomEnabled(true); //enable it to display a
            // custom view in the action bar.
            action.setCustomView(R.layout.searchbar);//add the custom view
            action.setDisplayShowTitleEnabled(false); //hide the title

            editSearch = (EditText)action.getCustomView().findViewById(R.id.search); //the text editor
            editSearch.requestFocus();
            //open the keyboard focused in the edtSearch
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.showSoftInput(editSearch, InputMethodManager.SHOW_IMPLICIT);
            isSearchOpened = true;
            //add the close icon
            mSearchAction.setIcon(R.drawable.ic_cancel_white_36pt);

            //this is a listener to do a search when the user clicks on search button
            editSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                        doSearch();
                        return true;
                    }
                    return false;
                }
            });
        }
    }

    private void doSearch() {
//
    }

    @Override
    public void onBackPressed() {
        if(isSearchOpened) {
            handleMenuSearch();
            return;
        }
        else{
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            }
        }
        super.onBackPressed();
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mSearchAction = menu.findItem(R.id.search);
        return super.onPrepareOptionsMenu(menu);
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




*/
/*          @Override
        public void showPopup(View v){
             PopupMenu popup = new PopupMenu(this, v);
             MenuInflater inflater = popup.getMenuInflater();

         }*/
