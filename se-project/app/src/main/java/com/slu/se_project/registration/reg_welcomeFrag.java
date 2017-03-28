package com.slu.se_project.registration;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
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
 * Use the {@link reg_welcomeFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class reg_welcomeFrag extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    reg_Activity _activity;

    private String Fname;
    private String Lname;

    public reg_welcomeFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment reg_welcomeFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static reg_welcomeFrag newInstance() {
        reg_welcomeFrag fragment = new reg_welcomeFrag();
     //   Bundle args = new Bundle();
     //   fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    /*    if (getArguments() != null) {
            Fname = getArguments().getString(Fname);
            Lname = getArguments().getString(Lname);
        }
*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.reg_welcome, container, false);


        final Button continueButton = (Button) v.findViewById(R.id.signUp_button);
        final EditText first = (EditText) v.findViewById(R.id.fname_editText);
        final EditText last = (EditText) v.findViewById(R.id.lname_editText);

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
 //SOFT INPUT not working past welcome Fragment

        first.requestFocus();

        last.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //modify to accomodate different keyboards????
                Log.i("KEY", Integer.toString(keyCode));
                if(keyCode == 66){
                    continueButton.performClick();
                    return true;
                }
                return false;
            }
        });

        continueButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                Fname = first.getEditableText().toString();
                Lname = last.getEditableText().toString();

                System.out.println("Fname:"+Fname);
                System.out.println("Lname:"+Lname);

                if(!(TextUtils.isEmpty(Fname)) && !(TextUtils.isEmpty(Lname))){
                    _activity._reg_contact.setName(Fname,Lname);
                    _activity.switchFrag("reg_User");
                }
                else {
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
