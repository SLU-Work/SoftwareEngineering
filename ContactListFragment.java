package edu.slu.cs.contactmanager;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dave on 2/22/17.
 */
public class ContactListFragment extends Fragment {
    ContactActivity _activity;
    ListView _contactList;
    ArrayList<int> _databaseIds;    // Ids for the names in the list view

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_list, parent, false);

        Button selectButton = (Button) view.findViewById(R.id.list_select_button);

        selectButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _activity.switchFragment("contact view");
            }
        });

        _contactList = (ListView) view.findViewById(R.id.list_contacts);

        displayContacts(view);

        return view;
    }

    // This should be called immediately after constuction.
    // The fragment needs to know the activity in order to switch screens.
    public void setActivity(ContactActivity activity) {
        _activity = activity;
    }

    // Display the current list of contacts
    public void displayContacts(View view) {
        // Define the columns of the table we want
        String[] columns = {
                ContactDBContract.ContactDBEntry._ID,
                ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST,
                ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST
        };

        // Define the sort order
        String sortOrder = ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST;

        // Perform the query
        Cursor cursor = _activity._db.query(
                ContactDBContract.ContactDBEntry.TABLE_NAME,
                columns,                // Which entries
                null, null,             // Selection
                null, null,             // Groupings
                sortOrder               // Ordering
        );

        // Iterate through results and store them in a list
        List names = new ArrayList<String>();
        _databaseIds.clear();
        while (cursor.moveToNext()) {
            String name;
            name = cursor.getString(cursor.getColumnIndex(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST))
                    + " " + cursor.getString(cursor.getColumnIndex(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST));

            names.add(name);
            _databaseIds.add(cursor.getInt(cursor.getColumnIndex(ContactDBContract.ContactDBEntry._ID)));
        }
        cursor.close();

        // Display the names to the listview
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, names);
        _contactList.setAdapter(adapter);
    }
}
