package com.slu.se_project.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.slu.se_project.R;

/**
 * Created by bharg on 2/6/2017.
 */

public class LoginFrag extends Fragment {

    private static final String TAG = LoginFrag.class.getSimpleName();
    protected ImageView appLogoImageView;
    protected EditText usernameEditText;
    protected EditText passwordEditText;
    protected TextView forgotPasswordTextView;
    protected Button createAccountButton;
    protected Button signInButton;
    reg_Activity _activity;

    public LoginFrag(){}

    public static LoginFrag newInstance(){
        LoginFrag fragment = new LoginFrag();
        return fragment;
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.reg_login, container, false);

//        appLogoImageView = (ImageView)findViewById(R.id.app_logo);
        usernameEditText = (EditText)v.findViewById(R.id.login_username);
        passwordEditText = (EditText)v.findViewById(R.id.login_password);
//        forgotPasswordTextView = (TextView)findViewById(R.id.login_forgot_password_link);
        createAccountButton = (Button)v.findViewById(R.id.register_button);
        signInButton = (Button)v.findViewById(R.id.login_button);
        //getNavigationDrawer().setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        usernameEditText.requestFocus();



        passwordEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //modify to accomodate different keyboards????
                if(keyCode == 66){
                    signInButton.performClick();
                    return true;
                }
                return false;
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(_activity.emailIsValid(usernameEditText) && _activity.passIsValid(passwordEditText)){
                    _activity.getBackendlessUser(usernameEditText.getText().toString(),passwordEditText.getText().toString());
                }
            }
        });

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _activity.viewFrag("welcome");
            }
        });



        return v;
    }

    public void setActivity(reg_Activity activity) {
        _activity = activity;
    }


}
