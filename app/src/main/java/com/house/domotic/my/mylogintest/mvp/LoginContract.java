package com.house.domotic.my.mylogintest.mvp;

public class LoginContract {

    public interface LoginResponse{

        void onLoginSuccess();
        void onLoginFailed();

    }

    public interface Presenter{

        void makeLogin(String user,String pass);

    }

    public interface View{

        void onLoginSuccess();
        void onLoginFailed();
    }

}
