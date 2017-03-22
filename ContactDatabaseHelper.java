package edu.slu.cs.contactmanager;

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
    public static final String DATABASE_NAME = "ContactManger.db";

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
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST, "Wayne");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST, "Bruce");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_PHONE, "911");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_EMAIL, "batman@cave.com");
        db.insert(ContactDBContract.ContactDBEntry.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST, "Kent");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST, "Clark");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_PHONE, "911");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_EMAIL, "superman@solitude.com");
        db.insert(ContactDBContract.ContactDBEntry.TABLE_NAME, null, values);

        values = new ContentValues();
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST, "Rogers");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST, "Steve");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_PHONE, "911");
        values.put(ContactDBContract.ContactDBEntry.COLUMN_NAME_EMAIL, "captain@america.gov");
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
