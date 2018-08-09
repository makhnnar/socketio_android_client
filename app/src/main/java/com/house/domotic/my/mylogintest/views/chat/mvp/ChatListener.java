package com.house.domotic.my.mylogintest.views.chat.mvp;

import android.app.Activity;
import android.util.Log;

import com.house.domotic.my.mylogintest.views.home.chatactivos.mvp.ChatActivosContract;

import org.json.JSONArray;

import io.socket.emitter.Emitter;

public class ChatListener implements Emitter.Listener{

    private ChatContract.FriendInteractor listener;

    private Activity activity;

    public ChatListener(ChatContract.FriendInteractor listener, Activity activity){
        this.listener = listener;
        this.activity = activity;
    }

    @Override
    public void call(final Object... arg0) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.i("cualquiera", "mensajes: ventanachat "+ arg0[0].toString());
                try{
                    JSONArray objeto = (JSONArray) arg0[0];
                    listener.chatRecieve(objeto);
                }catch(Exception e){
                    Log.e("cualquiera", "call: ventanachat " + e.getMessage());
                }
            }
        });
    }
}