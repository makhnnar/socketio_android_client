package com.house.domotic.my.mylogintest.views.home.chatactivos.mvp;

import android.app.Activity;
import android.util.Log;

import com.house.domotic.my.mylogintest.views.home.chatactivos.model.ChatActivosItemData;

import java.util.ArrayList;

public class ChatActivosPresenter implements
        ChatActivosContract.Presenter,
        ChatActivosContract.ChatResponse,
        ChatActivosContract.OnChatDeleteResponse{

    private ChatActivosContract.View view;

    private ChatActivosInteractor interactor;

    private ArrayList<ChatActivosItemData> mDataset = new ArrayList<>();

    public ChatActivosPresenter(ChatActivosContract.View view, Activity activity){
        this.view = view;
        interactor = new ChatActivosInteractor(this, activity);
    }


    @Override
    public void getChatActivos()   {
        Log.i("cualquiera", "getChatActivos: haciendo peticion");
        interactor.requestChats();

    }

    @Override
    public void deleteChatActivos(int pos)  {
        view.getChatActivosFailed();


    }

    @Override
    public void ChatActivosSuccess(ArrayList<ChatActivosItemData> mDataset) {
        if (mDataset != null){
            for (int i = 0; i < mDataset.size(); i++) Log.i("cualquiera", "ChatActivosSuccess:  "+ " "+ mDataset.get(i).getId());
            this.mDataset  = mDataset;
            view.getChatActivosSuccess(mDataset);

        }
    }

    @Override
    public void ChatActivosFailed() {

    }

    @Override
    public void deleteChatActivosSuccess() {

    }

    @Override
    public void deleteChatActivosFailed() {

    }
}
