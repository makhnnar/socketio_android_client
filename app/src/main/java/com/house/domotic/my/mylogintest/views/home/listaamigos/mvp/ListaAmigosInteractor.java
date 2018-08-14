package com.house.domotic.my.mylogintest.views.home.listaamigos.mvp;

import android.app.Activity;
import android.util.Log;

import com.house.domotic.my.mylogintest.views.home.listaamigos.model.ListaAmigosItemData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.socket.client.Manager;

public class ListaAmigosInteractor implements ListaAmigosContract.FriendInteractor{

    private ListaAmigosSocketManager manager;
    private ListaAmigosContract.ListaAmigosResponse response;

    public ListaAmigosInteractor(ListaAmigosContract.ListaAmigosResponse response, Activity activity){
        this.manager = new ListaAmigosSocketManager(this, activity);
        this.response = response;
    }

    public void requestListas(){
        Log.i("cualquiera", "requestListas: colocando el emit");
        manager.emit("friend_list", "");

    }

    @Override
    public void listaAmigosRecieve(JSONArray jsonArray) {
        ArrayList<ListaAmigosItemData> mDataset = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            try{
                JSONObject amigo = jsonArray.getJSONObject(i);
                mDataset.add(new ListaAmigosItemData(
                        amigo.getString("nombre"),
                        amigo.getString("estado"),
                        amigo.getString("foto"),
                        amigo.getString("id"))
                );
            }catch (JSONException e){
               // Log.i("cualquiera", "listaAmigosRecieve:  "+ e.getMessage());
            }
        }
        response.listaAmigosSuccess(mDataset);
    }

}


