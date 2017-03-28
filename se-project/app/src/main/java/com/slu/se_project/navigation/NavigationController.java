package com.slu.se_project.navigation;

import android.app.Activity;
import android.content.Intent;

import com.slu.se_project.PlanitApplication;

import java.lang.ref.WeakReference;

/**
 * Created by bharg on 2/6/2017.
 */

public class NavigationController {
    private static final String TAG = NavigationController.class.getName();

    private PlanitApplication mContext;

    private WeakReference<Activity> mCurrentView;

    public NavigationController(PlanitApplication context){
        mContext = context;
    }

    public void showView(NavigationScreens view){
        Intent intent = new Intent(mCurrentView.get(),view.get());
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mCurrentView.get().startActivity(intent);
    }

    public void viewShown(Activity activity){
        mCurrentView = new WeakReference<Activity>(activity);
    }

    public void finishCurrent(){
        if(mCurrentView!=null){
            if(mCurrentView.get()!=null){
                mCurrentView.get().finish();
            }
        }
    }

    public WeakReference<Activity> getCurrentView(){
        return mCurrentView;
    }
}
