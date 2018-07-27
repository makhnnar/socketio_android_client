package com.house.domotic.my.mylogintest.views.home.listaamigos.mvp;

import com.house.domotic.my.mylogintest.views.home.listaamigos.model.ListaAmigosItemData;

import java.util.ArrayList;

public class ListaAmigosInteractor {

    public ListaAmigosInteractor(){

    }

    public void requestListas(ListaAmigosContract.ListaAmigosResponse response){
        ArrayList<ListaAmigosItemData> mDataset = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mDataset.add(new ListaAmigosItemData("nombre " + i, "mensaje " + i, "foto " + i));
        }
        response.listaAmigosSuccess(mDataset);
    }
    }


