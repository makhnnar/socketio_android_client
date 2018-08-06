package com.house.domotic.my.mylogintest.views.home.profile.mvp;

import android.util.Log;

import com.house.domotic.my.mylogintest.views.chat.model.ChatItemData;
import com.house.domotic.my.mylogintest.views.home.profile.model.ProfileItemData;

import java.util.ArrayList;

public class ProfilePresenter implements
       ProfileContract.OnViewProfileResponse,
        ProfileContract.Presenter,
        ProfileContract.View
{

    private ProfileContract.View view;

    private ProfileInteractor interactor;

    private ArrayList<ProfileItemData> mDataset = new ArrayList<>();



    public ProfilePresenter(ProfileContract.View view) {
        this.view = view;
        interactor = new ProfileInteractor();
    }


    @Override
    public void onViewProfileSuccess(ArrayList<ProfileItemData> mDataset) {
        if (mDataset != null){
            this.mDataset.clear();
            this.mDataset  = mDataset;
            view.onReciveProfileSuccess(mDataset);

        }

    }

    @Override
    public void onViewProfileFailed() {

    }

    @Override
    public void getViewProfile() {
        interactor.requestProfile(this);

    }


    @Override
    public void onReciveProfileSuccess(ArrayList<ProfileItemData> mDataset) {


    }

    @Override
    public void onReciveProfileFailed() {

    }
}
/*
  agregarlo a la lista
  enviamos al interactor con su posicion en la lista
  enviamos la lista al view
  view pasa la lista al adaptador
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
            //this.mDataset.clear();
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
                "hora"

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
        interactor.requestMessage(this);
    }


 */