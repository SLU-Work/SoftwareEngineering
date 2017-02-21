package com.slu.se_project.backend;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessException;
import com.backendless.exceptions.BackendlessFault;
import com.slu.se_project.PlanitApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessionManager {


    public static final String TAG = SessionManager.class.getSimpleName();

    public static final String THROUGH_BACKENDLESS = "Backendless";

    private Users mCurrentUsers;

    public SessionManager(PlanitApplication application){
        mCurrentUsers = null;
    }

    public void loginWithBackendless(String email, String password){
        Backendless.UserService.login(email, password, new AsyncCallback<BackendlessUser>() {

            @Override
            public void handleResponse(BackendlessUser response) {
                 Backendless.UserService.setCurrentUser(response);
            }

            @Override
            public void handleFault(BackendlessFault fault) {


            }
        },true);

    }

}
