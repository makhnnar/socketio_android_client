package com.house.domotic.my.mylogintest.mvp;

public class LoginPresenter implements LoginContract.Presenter,LoginContract.LoginResponse{

    private LoginContract.View view;

    private LoginInteractor interactor;

    public LoginPresenter(LoginContract.View view){
        this.view = view;
        interactor = new LoginInteractor();
    }

    @Override
    public void makeLogin(String user, String pass) {
        interactor.requestLogin(this,user,pass);
    }

    @Override
    public void onLoginSuccess() {
        view.onLoginSuccess();
    }

    @Override
    public void onLoginFailed() {
        view.onLoginFailed();
    }
}
