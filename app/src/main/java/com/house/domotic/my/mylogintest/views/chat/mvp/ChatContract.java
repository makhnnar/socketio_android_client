package com.house.domotic.my.mylogintest.views.chat.mvp;

import com.house.domotic.my.mylogintest.views.chat.model.ChatItemData;

import org.json.JSONArray;

import java.util.ArrayList;

public class ChatContract {

    public interface  FriendInteractor{

        void chatRecieve(JSONArray jsonArray);

    }

    public interface SendMessageResponse{

        void onSendMessageSuccess(ArrayList<ChatItemData> mDataset);
        void onSendMessageFailed();

    }

    public interface ReciveMessageResponse {

        void onReciveMessageSuccess();
        void onReciveMessageFailed();
    }

    public interface ReciveAllChatMessageResponse {

        void onReciveAllChatMessageSuccess(ArrayList<ChatItemData> mDataset);
        void onReciveAllChatMessageFailed();

    }

    public interface Presenter{

        void sendMessage(String msj);
        void deleteMessage();
        void getAllMessage();



    }

    public interface View{

        void onReciveAllMessagesSuccess(ArrayList<ChatItemData> mDataset);
        void onReciveMessageSuccess();
        void onReciveAllMessagesFailed();
        void onReciveMessageFailed();
    }

}
