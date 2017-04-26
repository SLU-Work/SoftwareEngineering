package com.slu.se_project.contacts;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.slu.se_project.R;


import android.database.DatabaseUtils;

/**
 * Created by dave on 2/22/17.
 */
public class MListViewFragment extends Fragment {
    mListActivity _activity;
    ListView _contactList;
    ArrayList<Integer> _databaseIds = new ArrayList<Integer>();    // Ids for the names in the list view

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.mlist_viewfrag, parent, false);

       /* Button selectButton = (Button) view.findViewById(R.id.list_select_button);

        selectButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _activity.switchFragment("contact view");
            }
        });
*/
        _contactList = (ListView) view.findViewById(R.id.list_contacts);

        displayContacts(view);

        return view;
    }

    // This should be called immediately after constuction.
    // The fragment needs to know the activity in order to switch screens.
    public void setActivity(mListActivity activity) {
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
        //String sortOrder = ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST;

        // Perform the query
        Cursor cursor = _activity._db.query(
                ContactDBContract.ContactDBEntry.TABLE_NAME,
                columns,                // Which entries
                null, null,             // Selection
                null, null,             // Groupings
                null               // Ordering
        );

        System.out.println( DatabaseUtils.dumpCursorToString(cursor));
        // Iterate through results and store them in a list
        List names = new ArrayList<String>();
       // List contact_data = new ArrayList<Contact>();
       // if(_databaseIds != null)_databaseIds.clear();
        while (cursor.moveToNext()) {
            String name;
            name = cursor.getString(cursor.getColumnIndex(ContactDBContract.ContactDBEntry.COLUMN_NAME_FIRST))
                    + " " + cursor.getString(cursor.getColumnIndex(ContactDBContract.ContactDBEntry.COLUMN_NAME_LAST));

            names.add(name);
            _databaseIds.add(cursor.getInt(cursor.getColumnIndex(ContactDBContract.ContactDBEntry._ID)));
        }
        //cursor.close();

        Collections.sort(names);
        // Display the names to the listview
        mListAdapter adapter = new mListAdapter(getContext(), R.layout.row_item, names);
        _contactList.setAdapter(adapter);

        _contactList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //database call in Contact.java
                //_databaseIds.get(position) not necessarily correct bc sort
                //find logic to make this clause accurate
           //     if (!(_databaseIds.get(position).equals(_activity.active_Contact.id))){

                System.out.println("position: " + _databaseIds.get(position));
                System.out.println("position real: " + position);
                _activity.getActiveContact(_databaseIds.get(position));

                _activity.switchFragment("contact view");

            }
        });
    }
}
