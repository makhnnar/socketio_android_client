package com.house.domotic.my.mylogintest.views.chat.mvp;

public class ChatInteractor {

    private String name = "JUANCHO";
    private String pass = "1234";

    public ChatInteractor(){

    }

    public void requestLogin(ChatContract.LoginResponse response, String name, String pass){
        if(this.name.equals(name) && this.pass.equals(pass)){
            response.onLoginSuccess();
        }else{
            response.onLoginFailed();
        }
    }

}
