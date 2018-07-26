package com.house.domotic.my.mylogintest.views.home.listaamigos.mvp;

public class ListaAmigosPresenter implements ListaAmigosContract.Presenter,ListaAmigosContract.LoginResponse{

    private ListaAmigosContract.View view;

    private ListaAmigosInteractor interactor;

    public ListaAmigosPresenter(ListaAmigosContract.View view){
        this.view = view;
        interactor = new ListaAmigosInteractor();
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
