package com.house.domotic.my.mylogintest.views.chat.mvp;

public class ChatPresenter implements ChatContract.Presenter,ChatContract.LoginResponse{

    private ChatContract.View view;

    private ChatInteractor interactor;

    public ChatPresenter(ChatContract.View view){
        this.view = view;
        interactor = new ChatInteractor();
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
