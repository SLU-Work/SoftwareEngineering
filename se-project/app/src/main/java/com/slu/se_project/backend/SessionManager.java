package com.slu.se_project.backend;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;

import com.backendless.Backendless;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessionManager {


    public static final String TAG = SessionManager.class.getSimpleName();

    public static final String THROUGH_BACKENDLESS = "Backendless";

    private Users mCurrentUsers;



    public SessionManager(KollabstrApplication application){
        super(application);
        mCurrentUsers = null;
        subscribeToBus();
    }

    public void loginWithBackendless(String email, String password){
        Backendless.UserService.login(email, password, new AsyncCallback<BackendlessUser>() {

            @Override
            public void handleResponse(BackendlessUser response) {
                 AnswersManager.reportLogin(THROUGH_BACKENDLESS);
                 Backendless.UserService.setCurrentUser(response);
                 changeSession(response);
            }

            @Override
            public void handleFault(BackendlessFault fault) {


            }
        },true);

    }

   public void loginWithFacebook(Activity activity, CallbackManager callbackManager){
       Map<String,String> propertyMapping = new HashMap<>();
       propertyMapping.put("email","email");
       propertyMapping.put("id","facebookid");
       propertyMapping.put("first_name","name");
       List<String> permissions = new ArrayList<>();
       permissions.add("email");
        Backendless.UserService.loginWithFacebookSdk(activity, propertyMapping, permissions, callbackManager, new AsyncCallback<BackendlessUser>() {
            @Override
            public void handleResponse(BackendlessUser response) {
                AnswersManager.reportLogin(THROUGH_FACEBOOK);
                Backendless.UserService.setCurrentUser(response);
                changeSession(response);
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.d(TAG,fault.toString());
            }
        },true);
   }


    private void changeSession(BackendlessUser backendlessUser){
       sendNetworkRequest(new ChangeSessionRequest(backendlessUser));
    }

    public synchronized void updateUser(Users users){
        sendNetworkRequest(new UpdateUserRequest(users));
    }

    public synchronized void updateCurrentUser(){
        sendNetworkRequest(new UpdateUserRequest(mCurrentUsers));
        if(!mCurrentUsers.getProfile().getProfilePicture().getUrl().equals("")){ sendNetworkRequest(new DownloadProfilePictureRequest(mCurrentUsers.getProfile().getProfilePicture().getUrl()));}
        Log.d(TAG,"Downloading profile picture;");
    }

    public boolean isLoginRequired(){
        if(getCachedObject(K.Cache.CURRENT_USER)!=null){
                Log.d(TAG,"Loaded cached user!");
                mCurrentUsers = (Users)getCachedObject(K.Cache.CURRENT_USER);
                String userId = Backendless.UserService.loggedInUser();
                return !mCurrentUsers.getObjectId().equals(userId);
        }
        return true;
    }


    public Users getCurrentUser(){
        synchronized (this) {
            if (mCurrentUsers!=null) {
                return mCurrentUsers;
            }
        }
        throw new BackendlessException(TAG + " has no user signed in");
    }


    public void cacheLoggedInUser(){
        if(mCurrentUsers!=null){
            cacheObject(K.Cache.CURRENT_USER,mCurrentUsers);
            saveCache();
            Log.d(TAG,"Cached current user!");
        }
    }


    @Override
    public void handleEvent(Event event) {
        if(event.isEvent(K.Events.LOGGED_SESSION)){
            if(event.getMessage() instanceof Users){mCurrentUsers = (Users)event.getMessage();}
            updateCurrentUser();
            return;
        }

        if(event.isEvent(K.Events.UPDATED_USER)){
            if(event.getMessage() instanceof Users){
                if(mCurrentUsers!=null) {
                    if (!((Users) event.getMessage()).getObjectId().equals(mCurrentUsers.getObjectId())) {
                        getAppCache().invalidate();
                    }
                }
                mCurrentUsers = (Users)event.getMessage();
                Injector.map("currentUser").to(mCurrentUsers);
                cacheLoggedInUser();
            }
            return;
        }

        if(event.isEvent(K.Events.DOWNLOAD_PROFILE_PICTURE)){
            Log.d(TAG,"Caching profilePicture!");
            cacheBitmap(mCurrentUsers.getProfile().getObjectId()+"_profile",(Bitmap)event.getMessage());
        }

    }
}
