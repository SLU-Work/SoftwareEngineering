package edu.slu.cs.contactmanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by dave on 2/22/17.
 */

public class ContactViewFragment extends Fragment {
    ContactActivity _activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, parent, false);

        Button selectButton = (Button) view.findViewById(R.id.view_return_button);

        selectButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _activity.switchFragment("contact list");
            }
        });

        return view;
    }

    // This should be called immediately after constuction.
    // The fragment needs to know the activity in order to switch screens.
    public void setActivity(ContactActivity activity) {
        _activity = activity;
    }
}