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

    private boolean login_valid;
    private boolean reg_valid;
    public static final String TAG = SessionManager.class.getSimpleName();

    public static final String THROUGH_BACKENDLESS = "Backendless";

    private Users mCurrentUsers;

    public SessionManager(PlanitApplication application){
        mCurrentUsers = null;
    }

    public boolean loginWithBackendless(String email, String password){
        Backendless.UserService.login(email, password, new AsyncCallback<BackendlessUser>() {

            @Override
            public void handleResponse(BackendlessUser response) {
                 Backendless.UserService.setCurrentUser(response);
                 login_valid = true;
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                login_valid = false;
            }
        },true);
        return login_valid;

    }

    public boolean regWithBackendless(BackendlessUser user) {
        Backendless.UserService.register(user, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                Backendless.UserService.setCurrentUser(response);
                reg_valid = true;
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                reg_valid = false;
            }
        });
        return reg_valid;
    }
}
