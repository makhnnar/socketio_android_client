package com.house.domotic.my.mylogintest.views.chat.mvp;

import com.house.domotic.my.mylogintest.views.chat.model.ChatItemData;

import java.util.ArrayList;

public class ChatInteractor {

    public ChatInteractor() {

    }

    public void requestMessage(ChatContract.ReciveAllChatMessageResponse response) {
        ArrayList<ChatItemData> mDataset = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            mDataset.add(new ChatItemData("nombre " + i, "mensaje", "mensaje " + i, "foto " + i, "id" + i));

        }

        response.onReciveAllChatMessageSuccess(mDataset);
    }

    public void sendMessage(ChatContract.SendMessageResponse response, ChatItemData chatItemData, int position) {


    }



}
