package com.slu.se_project.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.slu.se_project.R;
import com.slu.se_project.navigation.NavigationActivity;

/**
 * Created by bharg on 2/6/2017.
 */

public class LoginActivity extends NavigationActivity implements View.OnClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        ((Button)findViewById(R.id.login_button)).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        String email = ((EditText)findViewById(R.id.login_email_edittext)).getText().toString();
        String password = ((EditText)findViewById(R.id.login_password_edittext)).getText().toString();
        getSessionManager().loginWithBackendless(email,password);
    }
}
