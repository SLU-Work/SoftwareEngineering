package com.slu.se_project.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.slu.se_project.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link reg_UserFrag . OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link reg_UserFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class reg_UserFrag extends Fragment {

    reg_Activity _activity;
    private String userName;
    private String email;

    public reg_UserFrag() {
        // Required empty public constructor
    }


    public static reg_UserFrag newInstance() {
        reg_UserFrag fragment = new reg_UserFrag();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.reg_user, container, false);

        final Button continueButton = (Button) v.findViewById(R.id.continue_button);
        final EditText editText = (EditText) v.findViewById(R.id.editText);
        final EditText editText2 = (EditText) v.findViewById(R.id.editText2);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        editText.requestFocus();

        editText2.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //modify to accomodate different keyboards????
                if(keyCode == 66){
                    continueButton.performClick();
                    return true;
                }
                return false;
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(_activity.emailIsValid(editText2)){
                    userName = editText.getText().toString();
                    email =  editText2.getText().toString();
                }

                if(!(TextUtils.isEmpty(userName)) && !(TextUtils.isEmpty(email))){
                    _activity._reg_contact.setUserName(userName, email);
                    _activity.viewFrag("reg_Pass");
                }
            }
        });
        return v;
    }


    public void setActivity(reg_Activity activity) {
        _activity = activity;
    }


}