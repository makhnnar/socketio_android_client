package com.house.domotic.my.mylogintest.views.home.friendrequest.mvp;

import android.app.Activity;
import android.util.Log;

import com.house.domotic.my.mylogintest.views.home.friendrequest.model.FriendRequestItemData;
import com.house.domotic.my.mylogintest.views.home.listaamigos.mvp.ListaAmigosContract;
import com.house.domotic.my.mylogintest.views.home.listaamigos.mvp.ListaAmigosSocketManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FriendRequestInteractor implements FriendRequestContract.FriendInteractor {

    private FriendRequestSocketManager manager;
    private FriendRequestContract.OnReciveAllFriendRequest response;

    public FriendRequestInteractor(FriendRequestContract.OnReciveAllFriendRequest response, Activity activity) {
        this.manager = new FriendRequestSocketManager(this, activity);
        this.response = response;
    }

    public void requestFriendship() {
        Log.i("cualquiera", "requesFriendship: colocando el emit");

    }

    @Override
    public void friendRequestRecieve(JSONArray jsonArray) {
        ArrayList<FriendRequestItemData> mDataset = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                JSONObject solicitudes = jsonArray.getJSONObject(i);
                mDataset.add(new FriendRequestItemData(
                        solicitudes.getString("nombre"),
                        solicitudes.getString("estado"),
                        solicitudes.getString("foto"),
                        solicitudes.getString("hora"),
                        solicitudes.getString("id"))
                );
            } catch (JSONException e) {

            }
        }
        response.onReciveRequestListSuccess(mDataset);

    }
}