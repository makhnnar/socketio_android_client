package com.house.domotic.my.mylogintest.views.chat.mvp;

import android.app.Activity;
import android.util.Log;

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



    public ChatPresenter(ChatContract.View view, Activity activity) {
        this.view = view;
        interactor = new ChatInteractor(this, activity);
    }


    @Override
    public void onSendMessageSuccess(ArrayList<ChatItemData> mDataset) {


    }

    @Override
    public void onSendMessageFailed() {

    }

    @Override
    public void onReciveMessageSuccess() {


    }

    @Override
    public void onReciveMessageFailed() {

    }

    @Override
    public void onReciveAllChatMessageSuccess(ArrayList<ChatItemData> listaMensaje) {
        if (listaMensaje != null) {
            for (int i = 0; i < mDataset.size(); i++) Log.i("cualquiera", "ChatActivosSuccess: ventanachat "+ " "+ mDataset.get(i).getId());
            this.mDataset = listaMensaje;
            view.onReciveAllMessagesSuccess(mDataset);

        }
    }

    @Override
    public void onReciveAllChatMessageFailed() {

    }

    @Override
    public void sendMessage(String msj) {

        ChatItemData chatItemData = new ChatItemData(
                "nombre",
                msj,
                "foto",
                "hora",
                "id"

        );
        mDataset.add(chatItemData);
        Log.i("verificar", "---"+ " " + mDataset.size());
        interactor.sendMessage(this, chatItemData, mDataset.size()-1);
        view.onReciveAllMessagesSuccess(mDataset);


    }

    @Override
    public void deleteMessage() {

    }

    @Override
    public void getAllMessage() {
        Log.i("cualquiera", "getChatActivos: ventanachat haciendo peticion");
        interactor.requestMessage();
    }
}
/*
  agregarlo a la lista
  enviamos al interactor con su posicion en la lista
  enviamos la lista al view
  view pasa la lista al adaptador
 */