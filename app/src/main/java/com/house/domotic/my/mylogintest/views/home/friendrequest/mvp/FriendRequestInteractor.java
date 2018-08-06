package com.house.domotic.my.mylogintest.views.home.friendrequest.mvp;

import com.house.domotic.my.mylogintest.views.home.friendrequest.model.FriendRequestItemData;

import java.util.ArrayList;

public class FriendRequestInteractor {

    public FriendRequestInteractor(){

    }



    public void requestFriendship(FriendRequestContract.OnReciveAllFriendRequest response) {
        ArrayList<FriendRequestItemData> mDataset = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            mDataset.add(new FriendRequestItemData("nombre " + i, "mensaje", "mensaje " + i, "foto " + i));

        }

        response.onReciveRequestListSuccess(mDataset);
    }

}