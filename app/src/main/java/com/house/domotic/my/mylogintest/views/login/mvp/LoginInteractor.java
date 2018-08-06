package com.house.domotic.my.mylogintest.views.login.mvp;

public class LoginInteractor {

    private String name = "JUANCHO";
    private String pass = "1234";

    public LoginInteractor(){

    }

    public void requestLogin(LoginContract.LoginResponse response,String name,String pass){
        if(this.name.equals(name) && this.pass.equals(pass)){
            response.onLoginSuccess();
        }else{
            response.onLoginFailed();
        }
    }

}
