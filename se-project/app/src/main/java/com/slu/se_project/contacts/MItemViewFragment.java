package com.slu.se_project.contacts;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.slu.se_project.R;


/**
 * Created by dave on 2/22/17.
 */

public class MItemViewFragment extends Fragment {
    mListActivity _activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mitem_viewfrag, parent, false);
/*
        final Button returnButton = (Button) view.findViewById(R.id.view_return_button);
        final Button editButton = (Button) view.findViewById(R.id.edit_button);

        final EditText first = (EditText) view.findViewById(R.id.first_editText);
        final EditText last = (EditText) view.findViewById((R.id.last_editText));
        final EditText email = (EditText) view.findViewById(R.id.email_editText);
        final EditText phone = (EditText) view.findViewById(R.id.phone_editText);

        first.setEnabled(false);
        last.setEnabled(false);
        email.setEnabled(false);
        phone.setEnabled(false);

        first.setText(_activity.active_Contact.contact_name_first);
        last.setText(_activity.active_Contact.contact_name_last);
        email.setText(_activity.active_Contact.email);
        phone.setText(_activity.active_Contact.phone);


        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _activity.switchFragment("contact list");
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (editButton.getText().equals("EDIT")){
                    first.setEnabled(true);
                    last.setEnabled(true);
                    email.setEnabled(true);
                    phone.setEnabled(true);

                    editButton.setText("SAVE");

                }
                else{
                    first.setEnabled(false);
                    last.setEnabled(false);
                    email.setEnabled(false);
                    phone.setEnabled(false);
                    editButton.setText("EDIT");

                    String update_first = first.getText().toString();
                    String update_last = last.getText().toString();
                    String update_email = email.getText().toString();
                    String update_phone = phone.getText().toString();
                    _activity.active_Contact.setContact(_activity.active_Contact.id,update_first,update_last,update_email,update_phone);
                    _activity.updateActiveContact();   // in database

                    //_activity.switchFragment("contact list");

                }

            }
        });
*/
        return view;
    }


    public void onStart() {
        super.onStart();

        final Button returnButton = (Button) getView().findViewById(R.id.view_return_button);
        final Button editButton = (Button) getView().findViewById(R.id.edit_button);

        final EditText first = (EditText) getView().findViewById(R.id.first_editText);
        final EditText last = (EditText) getView().findViewById((R.id.last_editText));
        final EditText email = (EditText) getView().findViewById(R.id.email_editText);
        final EditText phone = (EditText) getView().findViewById(R.id.phone_editText);

        first.setEnabled(false);
        last.setEnabled(false);
        email.setEnabled(false);
        phone.setEnabled(false);

        first.setText(_activity.active_Contact.contact_name_first);
        last.setText(_activity.active_Contact.contact_name_last);
        email.setText(_activity.active_Contact.email);
        phone.setText(_activity.active_Contact.phone);


        returnButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _activity.switchFragment("contact list");
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (editButton.getText().equals("EDIT")){
                    first.setEnabled(true);
                    last.setEnabled(true);
                    email.setEnabled(true);
                    phone.setEnabled(true);

                    editButton.setText("SAVE");

                }
                else{
                    first.setEnabled(false);
                    last.setEnabled(false);
                    email.setEnabled(false);
                    phone.setEnabled(false);
                    editButton.setText("EDIT");

                    String update_first = first.getText().toString();
                    String update_last = last.getText().toString();
                    String update_email = email.getText().toString();
                    String update_phone = phone.getText().toString();
                    _activity.active_Contact.setContact(_activity.active_Contact.id,update_first,update_last,update_email,update_phone);
                    _activity.updateActiveContact();   // in database

                    //_activity.switchFragment("contact list");

                }

            }
        });



    }

    // This should be called immediately after constuction.
    // The fragment needs to know the activity in order to switch screens.
    public void setActivity(mListActivity activity) {
        _activity = activity;
    }
}