package com.house.domotic.my.mylogintest.views.home.listaamigos.mvp;

public class ListaAmigosInteractor {

    private String name = "JUANCHO";
    private String pass = "1234";

    public ListaAmigosInteractor(){

    }

    public void requestLogin(ListaAmigosContract.LoginResponse response, String name, String pass){
        if(this.name.equals(name) && this.pass.equals(pass)){
            response.onLoginSuccess();
        }else{
            response.onLoginFailed();
        }
    }

}
