package com.slu.se_project.navigation;

import android.app.Activity;

import com.slu.se_project.login.LoginActivity;
import com.slu.se_project.main.MainActivity;
import com.slu.se_project.userProfile.UserProfileActivity;

/**
 * Created by bharg on 2/6/2017.
 */

public enum NavigationScreens {
//    SPLASH_VIEW(SplashActivity.class),
    LOGIN_VIEW(LoginActivity.class),
//    EULA_VIEW(EulaActivity.class),
    MAIN_VIEW(MainActivity.class),
    USER_PROFILE_VIEW(UserProfileActivity.class);
//    INSTALL_TSTAT_VIEW(InstallationActivity.class),
//    ACCOUNT_VIEW(PersonalInfoActivity.class),
//    EMAIL_PREFS_VIEW(EmailPreferencesActivity.class),
//    FEEDBACK_VIEW(FeedbackActivity.class),
//    DASHBOARD_VIEW(DashboardActivity.class);

    private Class<? extends Activity> mActivity;

    private NavigationScreens(Class<? extends Activity> activity){
        mActivity = activity;
    }

    public Class<? extends Activity> get(){
        return mActivity;
    }
}