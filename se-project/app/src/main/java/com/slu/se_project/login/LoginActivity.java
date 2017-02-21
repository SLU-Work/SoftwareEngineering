package com.slu.se_project.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.slu.se_project.main.MainActivity;
import com.slu.se_project.navigation.NavigationActivity;
import com.slu.se_project.R;

/**
 * Created by bharg on 2/6/2017.
 */

public class LoginActivity extends NavigationActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    protected ImageView appLogoImageView;
    protected EditText usernameEditText;
    protected EditText passwordEditText;
    protected TextView forgotPasswordTextView;
    protected Button createAccountButton;
    protected Button signInButton;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void setupViewHandles() {
//        appLogoImageView = (ImageView)findViewById(R.id.app_logo);
        usernameEditText = (EditText)findViewById(R.id.login_username);
        passwordEditText = (EditText)findViewById(R.id.login_password);
//        forgotPasswordTextView = (TextView)findViewById(R.id.login_forgot_password_link);
        createAccountButton = (Button)findViewById(R.id.register_button);
        signInButton = (Button)findViewById(R.id.login_button);
    }

    @Override
    protected void setupViewListeners() {
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSessionManager().loginWithBackendless(usernameEditText.getText().toString(),passwordEditText.getText().toString());
                openMainActivity();
            }
        });
    }

    @Override
    protected int getContentResourceId() {
        return R.layout.activity_login;
    }

    private void openMainActivity() {
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }

}
