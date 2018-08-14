package com.house.domotic.my.mylogintest.views.home.listaamigos.mvp;

import android.app.Activity;
import android.util.Log;

import org.json.JSONArray;

import io.socket.emitter.Emitter;

public class ListaAmigosListener implements Emitter.Listener{

    private ListaAmigosContract.FriendInteractor listener;

    private Activity activity;

    public ListaAmigosListener(ListaAmigosContract.FriendInteractor listener, Activity activity){
        this.listener = listener;
        this.activity = activity;
    }

    @Override
    public void call(final Object... arg0) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
              //  Log.i("cualquiera", "evento:  "+ arg0[0].toString());
                try{
                    JSONArray objeto = (JSONArray) arg0[0];
                    listener.listaAmigosRecieve(objeto);
                }catch(Exception e){
               //     Log.e("cualquiera", "call: " + e.getMessage());
                }

            }
        });



    }
}