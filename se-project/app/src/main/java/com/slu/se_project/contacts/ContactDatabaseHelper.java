package com.slu.se_project.contacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by dave on 2/22/17.
 */

public class ContactDatabaseHelper extends SQLiteOpenHelper {
    // Need versioning in case database schema changes
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ContactManager.db";

    public ContactDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        // Create the database table
        String command = "CREATE TABLE " + ContactDBContract.ContactDBEntry.TABLE_NAME + " (";
        command += ContactDBContract.ContactDBEntry._ID + " INTEGER PRIMARY KEY,";
        command += ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST + " TEXT,";
        command += ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST + " TEXT,";
        command += ContactDBContract.ContactDBEntry.COLUMN_NAME_PHONE + " TEXT,";
        command += ContactDBContract.ContactDBEntry.COLUMN_NAME_EMAIL + " TEXT";
        command += ")";

        db.execSQL(command);

        // Temporarily populate the database
        ContentValues values = new ContentValues();
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST, "Mi So");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST, "Banh");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_PHONE, "(314)353-0545");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_EMAIL, "4071 S. Grand Blvd");
        db.insert(ContactDBContract.ContactDBEntry.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST, "Brewing Company");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST, "Civil Life");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_PHONE, "CASH ONLY. NO PHONE NUMBER. WE HAVE BEER.");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_EMAIL, "3714 Holt Ave.");
        db.insert(ContactDBContract.ContactDBEntry.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST, "Ice Cream!");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST, "Clementine's Naughty and Nice");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_PHONE, "(314)858-6100");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_EMAIL, "1637 S 18th St.");
        db.insert(ContactDBContract.ContactDBEntry.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST, "Bar");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST, "Start");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_PHONE, "(314)376-4453");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_EMAIL, "1000 Spruce St.");
        db.insert(ContactDBContract.ContactDBEntry.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST, "& Wine Bar");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST, "Bridge Tap House");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_PHONE, "(314)241-8141");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_EMAIL, "1004 Locust St.");
        db.insert(ContactDBContract.ContactDBEntry.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST, "");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST, "Sanctuaria");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_PHONE, "(314)535-9700");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_EMAIL, "4198 Manchester Ave.I ");
        db.insert(ContactDBContract.ContactDBEntry.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST, "Pub");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST, "Nick's");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_PHONE, "(314)781-7806");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_EMAIL, "6001 Manchester Ave.");
        db.insert(ContactDBContract.ContactDBEntry.TABLE_NAME, null, values);



        Log.v("Contact Manager", "Populating database");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Delete the database and the recreate it
        String command = "DROP TABLE IF EXISTS " + ContactDBContract.ContactDBEntry.TABLE_NAME;
        db.execSQL(command);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
