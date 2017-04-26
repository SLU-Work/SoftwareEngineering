package com.slu.se_project.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;


import com.slu.se_project.R;
import com.slu.se_project.contacts.mListActivity;

import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link reg_PassFrag . OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link reg_PassFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class reg_PassFrag extends Fragment {

    reg_Activity _activity;

    private String pass;
    private String passConfirm;

  //  private OnFragmentInteractionListener mListener;

    public reg_PassFrag() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static reg_PassFrag newInstance() {
        reg_PassFrag fragment = new reg_PassFrag();
/*        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
*/        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
/*        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
*/  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.reg_pass, container, false);

        final Button continueButton = (Button) v.findViewById(R.id.done_button);
        final EditText editText = (EditText) v.findViewById(R.id.editText);
        final EditText editText2 = (EditText) v.findViewById(R.id.editText2);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        editText.requestFocus();

        //editText2.setError("Passwords are either not valid or matching");
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

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener(){
            @Override
            public void onFocusChange(View arg0, boolean arg1){_activity.passIsValid(editText);}
        });

        continueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pass = editText.getText().toString();
                passConfirm = editText2.getText().toString();

                if (!pass.equals(passConfirm)){
                    editText2.setError("Passwords do not match");
                }
                else{
                    editText2.setError(null);
                }

                if(editText.getError() == null && editText2.getError() == null  && (pass.length() >= 8)) {
                    _activity._reg_contact.setPass(pass);
                    _activity.regBackendlessUser();

                }
            }
        });
        return v;
    }

    public void setActivity(reg_Activity activity) {
      _activity = activity;
    }
/*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*
    public interface OnFragmentInteractionListener {
    // TODO: Update argument type and name
    void onFragmentInteraction(Uri uri);
    }
    */



}
