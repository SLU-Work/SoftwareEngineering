package com.slu.se_project.registration;

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

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment reg_UserFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static reg_UserFrag newInstance(String param1, String param2) {
        reg_UserFrag fragment = new reg_UserFrag();
/*        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 /*       if (getArguments() != null) {
            userName = getArguments().getString(ARG_PARAM1);
            email = getArguments().getString(ARG_PARAM2);
        }
*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.reg_user, container, false);

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

                userName = editText.getText().toString();
                email =  editText2.getText().toString();

                if(!(TextUtils.isEmpty(userName)) && !(TextUtils.isEmpty(email))){
                    _activity._reg_contact.setUserName(userName, email);
                    _activity.switchFrag("reg_Pass");
                } else {
                    // change editText autofill to red ink prompting submit
                }
            }
        });
        return v;
    }


    public void setActivity(reg_Activity activity) {
        _activity = activity;
    }


}