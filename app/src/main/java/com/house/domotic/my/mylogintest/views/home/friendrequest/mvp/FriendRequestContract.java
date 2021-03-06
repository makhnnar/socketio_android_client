package com.house.domotic.my.mylogintest.views.home.friendrequest.mvp;

import com.house.domotic.my.mylogintest.views.home.friendrequest.model.FriendRequestItemData;

import org.json.JSONArray;

import java.util.ArrayList;

public class FriendRequestContract {

    public interface  FriendInteractor{

        void friendRequestRecieve(JSONArray jsonArray);

    }



    public interface OnAcceptFriendResponse{

        void onAcceptFriendSuccess(ArrayList<FriendRequestItemData> mDataset);
        void onAcceptFriendFailed();

    }

    public interface OnDeclineFriendResponse{

        void onDeclineFriendSuccess();
        void onDeclineFriendFailed();
    }

    public interface  OnReciveAllFriendRequest {

        void  onReciveRequestListSuccess(ArrayList<FriendRequestItemData> mDataset);
        void  onReciveRequestListFailed();
    }

    public interface Presenter{


        void acceptFriendship();
        void declineFriendship(int pos);
        void getAllFrienshipNotifications();


    }

    public interface View{

        void onFriendRequestSuccess(ArrayList<FriendRequestItemData> mDataset);
        void onFriendRequestFailed();
        void onFriendRequestListSuccess(ArrayList<FriendRequestItemData> mDataset);
        void onFriendRequestListFailed();
    }

}

