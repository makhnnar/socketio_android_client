package com.house.domotic.my.mylogintest.views.home.profile.mvp;

import com.house.domotic.my.mylogintest.views.chat.model.ChatItemData;
import com.house.domotic.my.mylogintest.views.home.profile.model.ProfileItemData;

import java.util.ArrayList;

public class ProfileContract {

    public interface OnViewProfileResponse{

        void onViewProfileSuccess(ArrayList<ProfileItemData> mDataset);
        void onViewProfileFailed();

    }



    public interface Presenter{

        void getViewProfile();




    }

    public interface View{

        void onReciveProfileSuccess(ArrayList<ProfileItemData> mDataset);
        void onReciveProfileFailed();
    }

}
