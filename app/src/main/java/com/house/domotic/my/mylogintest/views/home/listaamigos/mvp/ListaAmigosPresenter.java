package com.house.domotic.my.mylogintest.views.home.listaamigos.mvp;

import android.app.Activity;
import android.util.Log;

import com.house.domotic.my.mylogintest.views.home.listaamigos.model.ListaAmigosItemData;

import java.util.ArrayList;

public class ListaAmigosPresenter implements
        ListaAmigosContract.Presenter,
        ListaAmigosContract.ListaAmigosResponse,
        ListaAmigosContract.OnListaDeleteResponse

{

    private ListaAmigosContract.View view;

    private ListaAmigosInteractor interactor;

    private ArrayList<ListaAmigosItemData> mDataset = new ArrayList<>();

    public ListaAmigosPresenter(ListaAmigosContract.View view, Activity activity) {
        this.view = view;
        interactor = new ListaAmigosInteractor(this, activity);
    }


    @Override
    public void getListaAmigos() {
      //  Log.i("cualquiera", "getListaAmigos: haciendo peticion");
        interactor.requestListas();
    }

    @Override
    public void deleteListaAmigos(int pos) {
        view.getListaAmigosFailed();
    }

    @Override
    public void listaAmigosSuccess(ArrayList<ListaAmigosItemData> mDataset) {
        if (mDataset != null) {
            //for (int i = 0; i < mDataset.size(); i++)Log.i("cualquiera", "getListaAmigosSuccess:  "+ " "+ mDataset.get(i).getId());
            this.mDataset.clear();
            this.mDataset = mDataset;
            view.getListaAmigosSuccess(mDataset);
        }

    }

    @Override
    public void listaAmigosFailed() {
    }

    @Override
    public void deleteListaAmigosSuccess() {
    }

    @Override
    public void deleteListaAmigosFailed() {
    }
}




