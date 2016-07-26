package com.login.mvp;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by lolipop on 7/27/16.
 */
public class LoginIntaraptImplimentation implements LoginIntarapt {
    @Override
    public void OnFinished(final String userName, final String userPassword, final OnFinishedLisener lisener) {
        new Handler().postDelayed(new Runnable() {

            boolean error = false;
            @Override
            public void run() {
                if (TextUtils.isEmpty(userName)){
                    lisener.showUserNameError();
                    error = true;
                }
                if (TextUtils.isEmpty(userPassword)){
                    lisener.showUserPasswordError();
                    error = true;
                }

                if (!error){
                    lisener.OnSuccess();
                }

            }
        }, 2000);
    }
}
