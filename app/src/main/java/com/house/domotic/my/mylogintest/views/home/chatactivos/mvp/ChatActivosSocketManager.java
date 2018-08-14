package com.house.domotic.my.mylogintest.views.home.chatactivos.mvp;

import android.app.Activity;
import android.util.Log;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class ChatActivosSocketManager {

    private static Socket socket;
    private ChatActivosContract.FriendInteractor listener;
    private String url = "http://192.168.0.104:4005";


    public ChatActivosSocketManager(ChatActivosContract.FriendInteractor listener, Activity activity){
        this.listener = listener;
        try {
            IO.Options opts = new IO.Options();
            opts.forceNew = true;
            opts.reconnection = true;
            socket = IO.socket(url,opts);
            socket.connect();
            socket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
                @Override
                public void call(Object... args) {
                    Log.i("cualquiera", "call: ChatActivosSocketManager se conecto");
                }
            });
            socket.on("actv_chats", new ChatActivosListener(this.listener, activity));

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void emit(String evento,String msg){
        try {
            socket.emit(evento, msg);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("EXCEPCION: "+e.getMessage());
        }
    }

}
