package com.house.domotic.my.mylogintest.views.home.friendrequest.mvp;

import android.app.Activity;
import android.util.Log;

import com.house.domotic.my.mylogintest.views.home.friendrequest.model.FriendRequestItemData;

import java.util.ArrayList;

public class FriendRequestPresenter implements
        FriendRequestContract.OnAcceptFriendResponse,
        FriendRequestContract.OnDeclineFriendResponse,
        FriendRequestContract.OnReciveAllFriendRequest,
        FriendRequestContract.Presenter,
        FriendRequestContract.View {


    private FriendRequestContract.View view;

    private FriendRequestInteractor interactor;

    private ArrayList<FriendRequestItemData> mDataset = new ArrayList<>();

    public FriendRequestPresenter(FriendRequestContract.View view, Activity activity){
        this.view = view;
        interactor = new FriendRequestInteractor(this, activity);

    }

    @Override
    public void onAcceptFriendSuccess(ArrayList<FriendRequestItemData> mDataset) {

    }

    @Override
    public void onAcceptFriendFailed() {

    }

    @Override
    public void onDeclineFriendSuccess() {

    }

    @Override
    public void onDeclineFriendFailed() {

    }

    @Override
    public void onReciveRequestListSuccess(ArrayList<FriendRequestItemData> mDataset) {
        if (mDataset != null) {
            for (int i = 0; i < mDataset.size(); i++) Log.i("cualquiera", "onReciveRequestListSuccess:  "+ " "+ mDataset.get(i).getId());
            this.mDataset = mDataset;
            view.onFriendRequestListSuccess(mDataset);

        }
    }

    @Override
    public void onReciveRequestListFailed() {

    }

    @Override
    public void acceptFriendship() {

    }

    @Override
    public void declineFriendship(int pos) {

    }

    @Override
    public void getAllFrienshipNotifications() {
        Log.i("cualquiera", "getAllFrienshipNotifications: haciendo peticion");
        interactor.requestFriendship();

    }

    @Override
    public void onFriendRequestSuccess(ArrayList<FriendRequestItemData> mDataset) {

    }

    @Override
    public void onFriendRequestFailed() {

    }

    @Override
    public void onFriendRequestListSuccess(ArrayList<FriendRequestItemData> mDataset) {

    }

    @Override
    public void onFriendRequestListFailed() {

    }
}
