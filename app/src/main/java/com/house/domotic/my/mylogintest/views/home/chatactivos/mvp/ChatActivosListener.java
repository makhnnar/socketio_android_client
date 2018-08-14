package com.house.domotic.my.mylogintest.views.home.chatactivos.mvp;

import android.app.Activity;
import android.util.Log;
import org.json.JSONArray;
import io.socket.emitter.Emitter;

public class ChatActivosListener implements Emitter.Listener{

    private ChatActivosContract.FriendInteractor listener;

    private Activity activity;

    public ChatActivosListener(ChatActivosContract.FriendInteractor listener, Activity activity){
        this.listener = listener;
        this.activity = activity;
    }

    @Override
    public void call(final Object... arg0) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.i("cualquiera", "listasolicitudes: ChatActivos "+ arg0[0].toString());
                try{
                    JSONArray objeto = (JSONArray) arg0[0];
                    listener.chatActivosRecieve(objeto);
                }catch(Exception e){
                    Log.e("cualquiera", "call: ChatActivos " + e.getMessage());
                }
            }
        });
    }
}