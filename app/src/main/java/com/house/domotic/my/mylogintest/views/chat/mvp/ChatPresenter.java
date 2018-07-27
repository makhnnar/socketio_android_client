package com.house.domotic.my.mylogintest.views.chat.mvp;

import com.house.domotic.my.mylogintest.views.chat.model.ChatItemData;

import java.util.ArrayList;

public class ChatPresenter implements
        ChatContract.Presenter,
        ChatContract.SendMessageResponse,
        ChatContract.ReciveMessageResponse,
        ChatContract.ReciveAllChatMessageResponse {

    private ChatContract.View view;

    private ChatInteractor interactor;

    private ArrayList<ChatItemData> mDataset = new ArrayList<>();

    public ChatPresenter(ChatContract.View view) {
        this.view = view;
        interactor = new ChatInteractor();
    }


    @Override
    public void onSendMessageSuccess() {

    }

    @Override
    public void onSendMessageFailed() {

    }

    @Override
    public void onReciveMessageSuccess() {
        interactor.requestMessage(this);

    }

    @Override
    public void onReciveMessageFailed() {

    }

    @Override
    public void onReciveAllChatMessageSuccess(ArrayList<ChatItemData> mDataset) {
        if (mDataset != null){
            this.mDataset.clear();
            this.mDataset  = mDataset;
            view.onReciveAllMessagesSuccess(mDataset);

    }

    @Override
    public void onReciveAllChatMessageFailed() {

    }

    @Override
    public void onSendMessage() {


    }

    @Override
    public void onDeleteMessage() {

    }
}
