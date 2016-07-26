package com.login.mvp;

/**
 * Created by lolipop on 7/27/16.
 */
public interface LoginViewPresenter {

    void OnFinishedSuccess(String userName, String userPassword);
    void OnDestroy();
}
