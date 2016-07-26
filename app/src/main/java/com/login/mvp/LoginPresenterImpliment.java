package com.login.mvp;

/**
 * Created by lolipop on 7/27/16.
 */
public class LoginPresenterImpliment implements LoginViewPresenter , LoginIntarapt.OnFinishedLisener {


    private LoginView loginView;
    private LoginIntarapt loginIntarapt;


    public LoginPresenterImpliment(LoginView loginView){
        this.loginView = loginView;
        loginIntarapt = new LoginIntaraptImplimentation();
    }


    @Override
    public void OnFinishedSuccess(String userName, String userPassword) {
        if (loginView!=null){
            loginView.showProgressBar();
        }

        loginIntarapt.OnFinished(userName , userPassword  , this);
    }


    @Override
    public void OnDestroy() {

        if (loginView!=null){
            loginView = null;
        }
    }

    @Override
    public void showUserNameError() {
        if (loginView!=null){
            loginView.setUserNameError();
            loginView.hideProgressBar();
        }
    }

    @Override
    public void showUserPasswordError() {
        if (loginView!=null){
            loginView.setUserPasswordError();
            loginView.hideProgressBar();
        }
    }

    @Override
    public void OnSuccess() {

        if (loginView!=null){
            loginView.OnGoToAnotherAcitivity();
        }
    }
}
