package com.house.domotic.my.mylogintest.views.home.chatactivos.mvp;

import com.house.domotic.my.mylogintest.views.home.chatactivos.model.ChatActivosItemData;

import java.util.ArrayList;

public class ChatActivosPresenter implements
        ChatActivosContract.Presenter,
        ChatActivosContract.ChatResponse,
        ChatActivosContract.OnChatDeleteResponse{

    private ChatActivosContract.View view;

    private ChatActivosInteractor interactor;

    private ArrayList<ChatActivosItemData> mDataset = new ArrayList<>();

    public ChatActivosPresenter(ChatActivosContract.View view){
        this.view = view;
        interactor = new ChatActivosInteractor();
    }


    @Override
    public void getChatActivos()   {
        interactor.requestChats(this);

    }

    @Override
    public void deleteChatActivos(int pos)  { view.getChatActivosFailed();


    }

    @Override
    public void getChatActivosSuccess(ArrayList<ChatActivosItemData> mDataset) {
        if (mDataset != null){
            this.mDataset.clear();
            this.mDataset  = mDataset;
            view.getChatActivosSuccess(mDataset);

        }
    }

    @Override
    public void getChatActivosFailed() {

    }

    @Override
    public void deleteChatActivosSuccess() {

    }

    @Override
    public void deleteChatActivosFailed() {

    }
}
