package com.house.domotic.my.mylogintest.views.home.listaamigos.mvp;

public class ListaAmigosContract {

    public interface LoginResponse{

        void onLoginSuccess();
        void onLoginFailed();

    }

    public interface Presenter{

        void makeLogin(String user, String pass);

    }

    public interface View{

        void onLoginSuccess();
        void onLoginFailed();
    }

}
