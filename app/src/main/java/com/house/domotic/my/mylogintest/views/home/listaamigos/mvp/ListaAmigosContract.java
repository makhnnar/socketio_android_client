package com.house.domotic.my.mylogintest.views.home.listaamigos.mvp;

import com.house.domotic.my.mylogintest.views.home.listaamigos.model.ListaAmigosItemData;

import org.json.JSONArray;

import java.util.ArrayList;

public class ListaAmigosContract {

    public interface  FriendInteractor{
        void listaAmigosRecieve(JSONArray jsonArray);

    }

    public interface ListaAmigosResponse{

        void listaAmigosSuccess(ArrayList<ListaAmigosItemData> mDataset);
        void listaAmigosFailed();

    }   public interface OnListaDeleteResponse{

        void deleteListaAmigosSuccess();
        void deleteListaAmigosFailed();
    }

    public interface Presenter{

        void getListaAmigos();
        void deleteListaAmigos(int pos);

    }

    public interface View{

        void getListaAmigosSuccess(ArrayList<ListaAmigosItemData> mDataset);
        void getListaAmigosFailed();
    }

}
