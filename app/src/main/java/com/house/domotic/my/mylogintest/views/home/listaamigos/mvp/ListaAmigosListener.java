package com.house.domotic.my.mylogintest.views.home.listaamigos.mvp;

public class ListaAmigosListener implements Emitter.Listener{

    private IOSocketMessageListener listener;

    public PmMsgInteractor(IOSocketMessageListener listener){
        this.listener = listener;
    }

    @Override
    public void call(Object... arg0) {
        try{
            JSONObject objeto = (JSONObject)arg0[0];
            listener.recievePmMSG(objeto.getString("nickname"),objeto.getString("message"));
        }catch(Exception e){

        }
    }
}