package edu.slu.cs.contactmanager;

import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

public class ContactActivity extends FragmentActivity {
    ContactListFragment _contactListFragment;
    ContactViewFragment _viewListFragment;
    SQLiteDatabase _db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        // Initialize the fragments if they do not exist
        if (_contactListFragment == null) {
            _contactListFragment = new ContactListFragment();
            _contactListFragment.setActivity(this);
        }
        if (_viewListFragment == null) {
            _viewListFragment = new ContactViewFragment();
            _viewListFragment.setActivity(this);
        }

        // Add the initial fragment
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.activity_contact, _contactListFragment).commit();

        // Initialize the database if it does not exist
        if (_db == null) {
            ContactDatabaseHelper dbHelper = new ContactDatabaseHelper(getBaseContext());
            _db = dbHelper.getWritableDatabase();
        }
    }

    public void switchFragment(String newFragment) {
        if (newFragment == "contact view") {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.activity_contact, _viewListFragment).commit();
        }
        else if (newFragment == "contact list") {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.activity_contact, _contactListFragment).commit();
        }
    }
}
