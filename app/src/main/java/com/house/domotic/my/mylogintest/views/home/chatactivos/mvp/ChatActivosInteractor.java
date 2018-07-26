package com.house.domotic.my.mylogintest.views.home.chatactivos.mvp;

import com.house.domotic.my.mylogintest.views.home.chatactivos.model.ChatActivosItemData;

import java.util.ArrayList;

public class ChatActivosInteractor {


    public ChatActivosInteractor(){

    }

    public void requestChats(ChatActivosContract.ChatResponse response){
        ArrayList<ChatActivosItemData> mDataset = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mDataset.add(new ChatActivosItemData("nombre " + i, "mensaje " + i, "foto " + i));
        }
        response.getChatActivosSuccess(mDataset);
    }


    /*borre*/
}
