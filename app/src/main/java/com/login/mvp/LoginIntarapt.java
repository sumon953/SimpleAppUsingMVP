package com.login.mvp;

/**
 * Created by lolipop on 7/27/16.
 */
public interface LoginIntarapt {

    interface OnFinishedLisener{
        void showUserNameError();
        void showUserPasswordError();
        void OnSuccess();
    }

    void OnFinished(String userName, String userPassword, OnFinishedLisener lisener);
}
