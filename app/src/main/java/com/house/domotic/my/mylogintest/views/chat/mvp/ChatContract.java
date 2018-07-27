package com.house.domotic.my.mylogintest.views.chat.mvp;

import com.house.domotic.my.mylogintest.views.chat.model.ChatItemData;

import java.util.ArrayList;

public class ChatContract {

    public interface SendMessageResponse{

        void onSendMessageSuccess();
        void onSendMessageFailed();

    }

    public interface ReciveMessageResponse {

        void onReciveMessageSuccess();
        void onReciveMessageFailed();
    }

    public interface ReciveAllChatMessageResponse {

        void onReciveAllChatMessageSuccess();
        void onReciveAllChatMessageFailed();

    }

    public interface Presenter{

        void onSendMessage();
        void onDeleteMessage();

    }

    public interface View{

        void onReciveAllMessagesSuccess(ArrayList<ChatItemData> mDataset);
        void onReciveMessageSuccess();
        void onReciveAllMessagesFailed();
        void onReciveMessageFailed();
    }

}
