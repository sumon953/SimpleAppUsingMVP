package com.login.mvp;

/**
 * Created by lolipop on 7/27/16.
 */
public interface LoginView {

    void showProgressBar();
    void hideProgressBar();
    void setUserNameError();
    void setUserPasswordError();
    void OnGoToAnotherAcitivity();
}
