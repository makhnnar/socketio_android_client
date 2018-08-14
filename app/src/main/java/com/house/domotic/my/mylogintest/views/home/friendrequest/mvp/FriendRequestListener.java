package com.house.domotic.my.mylogintest.views.home.friendrequest.mvp;

import android.app.Activity;
import android.util.Log;

import org.json.JSONArray;

import io.socket.emitter.Emitter;

public class FriendRequestListener implements Emitter.Listener{

    private FriendRequestContract.FriendInteractor listener;

    private Activity activity;

    public FriendRequestListener(FriendRequestContract.FriendInteractor listener, Activity activity){
        this.listener = listener;
        this.activity = activity;
    }

    @Override
    public void call(final Object... arg0) {
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.i("cualquiera", "listasolicitudes:  "+ arg0[0].toString());
                try{
                    JSONArray objeto = (JSONArray) arg0[0];
                    listener.friendRequestRecieve(objeto);
                }catch(Exception e){
                    Log.e("cualquiera", "call: " + e.getMessage());
                }

            }
        });



    }
}