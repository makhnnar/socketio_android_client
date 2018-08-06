package com.house.domotic.my.mylogintest.views.home.profile.mvp;

import com.house.domotic.my.mylogintest.views.chat.model.ChatItemData;
import com.house.domotic.my.mylogintest.views.home.profile.model.ProfileItemData;

import java.util.ArrayList;

public class ProfileInteractor {

    public ProfileInteractor() {

    }

    public void requestProfile(ProfileContract.OnViewProfileResponse response) {
        ArrayList<ProfileItemData> mDataset = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            mDataset.add(new ProfileItemData("nombre " + i, "estado", "foto" + i, "conexion" + i, "telefono" + i));

        }

        response.onViewProfileSuccess(mDataset);
    }


}
