package com.house.domotic.my.mylogintest.views.chat.mvp;

import android.app.Activity;
import android.util.Log;

import com.house.domotic.my.mylogintest.views.chat.model.ChatItemData;
import com.house.domotic.my.mylogintest.views.home.chatactivos.model.ChatActivosItemData;
import com.house.domotic.my.mylogintest.views.home.chatactivos.mvp.ChatActivosSocketManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChatInteractor implements ChatContract.FriendInteractor {

    private ChatContract.ReciveAllChatMessageResponse response;
    private ChatSocketManager manager;

    public ChatInteractor(ChatContract.ReciveAllChatMessageResponse response, Activity activity) {
        this.manager = new ChatSocketManager(this, activity);
        this.response = response;


    }

    public void requestMessage() {
        Log.i("cualquiera", "requesmessage: ventanachat colocando el emit");
        manager.emit("chats", "");

    }

    public void sendMessage(ChatContract.SendMessageResponse response, ChatItemData chatItemData, int position) {

    }

    @Override
    public void chatRecieve(JSONArray jsonArray) {
        ArrayList<ChatItemData> mDataset = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject mensajes = jsonArray.getJSONObject(i);
                mDataset.add(new ChatItemData(
                        mensajes.getString("nombre"),
                        mensajes.getString("mensaje"),
                        mensajes.getString("foto"),
                        mensajes.getString("hora"),
                        mensajes.getString("id"))
                );
            } catch (JSONException e) {
                Log.i("cualquiera", "chatRecieve: ventanachat " + e.getMessage());

            }
            response.onReciveAllChatMessageSuccess(mDataset);
        }
    }
}