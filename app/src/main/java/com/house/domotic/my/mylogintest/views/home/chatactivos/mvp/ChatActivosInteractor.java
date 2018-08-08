package com.house.domotic.my.mylogintest.views.home.chatactivos.mvp;

import android.app.Activity;

import com.house.domotic.my.mylogintest.views.home.chatactivos.model.ChatActivosItemData;
import com.house.domotic.my.mylogintest.views.home.friendrequest.model.FriendRequestItemData;
import com.house.domotic.my.mylogintest.views.home.friendrequest.mvp.FriendRequestContract;
import com.house.domotic.my.mylogintest.views.home.friendrequest.mvp.FriendRequestSocketManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ChatActivosInteractor implements ChatActivosContract.FriendInteractor{

    private ChatActivosSocketManager manager;
    private ChatActivosContract.ChatResponse response;


    public ChatActivosInteractor(ChatActivosContract.ChatResponse response, Activity activity) {
        this.manager = new ChatActivosSocketManager(this, activity);
        this.response = response;
    }

    public void requestChats(){
        manager.emit("actv_chats", "");

    }

    public void chatActivosRecieve(JSONArray jsonArray) {
        ArrayList<ChatActivosItemData> mDataset = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject conversaciones = jsonArray.getJSONObject(i);
                mDataset.add(new ChatActivosItemData(
                        conversaciones.getString("nombre"),
                        conversaciones.getString("mensaje"),
                        conversaciones.getString("foto"),
                        conversaciones.getString("id"))
                );
            } catch (JSONException e) {

            }
        }
        response.ChatActivosSuccess(mDataset);

    }


    /*borre*/
}
