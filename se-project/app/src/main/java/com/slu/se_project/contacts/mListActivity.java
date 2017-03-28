package com.slu.se_project.contacts;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.slu.se_project.R;


public class mListActivity extends AppCompatActivity {
    MListViewFragment _mListViewFragment;
    MItemViewFragment _viewContactFragment;
    SQLiteDatabase _db;
    Contact active_Contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mlist_activity);

/*        Toolbar contactToolbar = (Toolbar)findViewById(R.id.mlist_toolbar);
        setSupportActionBar(contactToolbar);
*/
        // Initialize master copy of Contact for MItemViewFragment
        if (active_Contact == null){
            active_Contact = new Contact();
        }
        // Initialize the fragments if they do not exist
        if (_mListViewFragment == null) {
            _mListViewFragment = new MListViewFragment();
            _mListViewFragment.setActivity(this);
        }
        if (_viewContactFragment == null) {
            _viewContactFragment = new MItemViewFragment();
            _viewContactFragment.setActivity(this);
        }
        // Initialize the database if it does not exist
        if (_db == null) {
            ContactDatabaseHelper dbHelper = new ContactDatabaseHelper(getApplicationContext());
            _db = dbHelper.getWritableDatabase();
        }
        // Add the initial fragment
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.activity_contact, _mListViewFragment).commit();


    }

    public void switchFragment(String newFragment) {
        if (newFragment.equals("contact view")) {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.activity_contact, _viewContactFragment).commit();
        }
        else if (newFragment.equals("contact list")) {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.activity_contact, _mListViewFragment).commit();
            if(_viewContactFragment != null)
                fm.beginTransaction().remove(_viewContactFragment).commit();

        }
    }

    public void getActiveContact(Integer primary){

        Cursor cursor = _db.query(
                ContactDBContract.ContactDBEntry.TABLE_NAME,
                null,                // Which entries
                "_id=?", new String[]{primary.toString()},             // Selection
                null, null,             // Groupings
                null               // Ordering
        );
        cursor.moveToFirst();

        String first = cursor.getString(cursor.getColumnIndex(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST));
        String last = cursor.getString(cursor.getColumnIndex(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST));
        String email = cursor.getString(cursor.getColumnIndex(ContactDBContract.ContactDBEntry.COLUMN_NAME_EMAIL));
        String phone = cursor.getString(cursor.getColumnIndex(ContactDBContract.ContactDBEntry.COLUMN_NAME_PHONE));

        active_Contact.setContact(primary,first,last,email,phone);

        System.out.println( DatabaseUtils.dumpCursorToString(cursor));
        System.out.println("Contact stuff:" + active_Contact.id + '|' + active_Contact.contact_name_first + '|' + active_Contact.contact_name_last);

        cursor.close();

    }

    public void updateActiveContact(){

        ContentValues cv = new ContentValues();
        cv.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST, active_Contact.contact_name_first);
        cv.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST, active_Contact.contact_name_last);
        cv.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_EMAIL, active_Contact.email);
        cv.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_PHONE, active_Contact.phone);

        _db.update(ContactDBContract.ContactDBEntry.TABLE_NAME, cv, "_id="+active_Contact.id, null);
    }
}
