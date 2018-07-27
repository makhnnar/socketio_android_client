package com.house.domotic.my.mylogintest.views.home.listaamigos.mvp;

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

    public ListaAmigosPresenter(ListaAmigosContract.View view){
        this.view = view;
        interactor = new ListaAmigosInteractor();
    }

            @Override
            public void getListaAmigos() {
                interactor.requestListas(this);
            }

            @Override
            public void deleteListaAmigos(int pos) {view.getListaAmigosFailed();
            }

            @Override
            public void listaAmigosSuccess(ArrayList<ListaAmigosItemData> mDataset) {
                if (mDataset != null) {
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




