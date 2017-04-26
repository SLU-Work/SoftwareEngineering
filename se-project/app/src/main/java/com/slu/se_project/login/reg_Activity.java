package com.slu.se_project.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.slu.se_project.R;
import com.slu.se_project.contacts.mListActivity;
import com.slu.se_project.main.MainActivity;
import com.slu.se_project.navigation.NavigationActivity;

import java.util.Map;
import java.util.regex.Pattern;


/**
 * Created by Sean on 2/28/2017.
 */

public class reg_Activity extends NavigationActivity{

    reg_welcomeFrag _reg_welcomeFrag;
    reg_UserFrag _regUserFrag;
    reg_PassFrag _regPassFrag;
    reg_Contact _reg_contact;
    LoginFrag _loginFrag;

    private static boolean fragmentsSupported = false;
/*
    private static void checkFragmentsSupported() throws NoClassDefFoundError {
        fragmentsSupported = android.app.Fragment.class != null;
    }


    static{
        try{
            checkFragmentsSupported();
        } catch (NoClassDefFoundError e){
            fragmentsSupported = false;
        }
    }

    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_activity);

        if(_loginFrag == null){
            _loginFrag = new LoginFrag();
            _loginFrag.setActivity(this);
        }
        if(_reg_contact == null){
            _reg_contact = new reg_Contact();
        }
        if(_reg_welcomeFrag == null){
            _reg_welcomeFrag = new reg_welcomeFrag();
            _reg_welcomeFrag.setActivity(this);
        }

        if(_regUserFrag == null){
            _regUserFrag = new reg_UserFrag();
            _regUserFrag.setActivity(this);
        }

        if(_regPassFrag == null){
            _regPassFrag = new reg_PassFrag();
            _regPassFrag.setActivity(this);
        }
      viewFrag("login");
    }

    @Override
    protected int getContentResourceId() {
        return R.layout.reg_activity;
    }

    public void viewFrag(String newFrag){
        //FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        switch(newFrag){
            case "login" :
                t.add(R.id.initialactivity, _loginFrag);
                break;
            case "welcome" :
                t.replace(R.id.initialactivity, _reg_welcomeFrag);
                break;
            case "reg_User" :
                t.replace(R.id.initialactivity, _regUserFrag);
                break;
            case "reg_Pass" :
                t.replace(R.id.initialactivity, _regPassFrag);
                break;
        }
        t.addToBackStack(null);
        t.commit();
    }

    @Override
    public void onBackPressed(){
        if(getSupportFragmentManager().getBackStackEntryCount() == 1){
            finish();
        }else{
            getSupportFragmentManager().popBackStack();
        }

    }

    public boolean passIsValid(EditText editText){

        String password = editText.getText().toString();

        Pattern specialCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");
        boolean flag = true;
        /*
        boolean flag = false;
        if (password.length() < 8) {
            editText.setError("Password length must have at least 8 character !!");
        }
        else if (!UpperCasePatten.matcher(password).find()) {
            editText.setError("Password must have atleast one uppercase character !!");
        }
        else if (!lowerCasePatten.matcher(password).find()) {
            editText.setError("Password must have atleast one lowercase character !!");
        }
        else if (!digitCasePatten.matcher(password).find()) {
            editText.setError("Password must have atleast one digit character !!");
        }
        else{
            flag = true;
        }
 */       return flag;
    }

    public boolean emailIsValid(EditText editText){
        String email = editText.getText().toString().trim();

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        boolean flag = false;
        if (email.matches(emailPattern)){
            editText.setError(null);
            flag = true;
        }
        else{
            editText.setError("Email is invalid.");


        }
        return flag;
    }

    public void getBackendlessUser(String user, String pass){
        Log.d("Login","user"+ user + "pass:" + pass);
        if(getSessionManager().loginWithBackendless(user,pass)){
            Log.d("Login","user"+ user + "pass:" + pass);

            //get data to populate main first
            openMainActivity();

        }else{
            Toast.makeText(this, "Um, you got that wrong, try again", Toast.LENGTH_LONG).show();
        }

    }

    public void regBackendlessUser(){
        BackendlessUser user = new BackendlessUser();
        user.setProperties(_reg_contact.getBackUser());
        user.setPassword(_reg_contact.pass);
        if(getSessionManager().regWithBackendless(user)){
            //get data to populate main first
            openMainActivity();
        }else{
            Toast.makeText(this, "Um, you got that wrong, try again", Toast.LENGTH_LONG).show();
        }
    }

    private void openMainActivity() {
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }

}
