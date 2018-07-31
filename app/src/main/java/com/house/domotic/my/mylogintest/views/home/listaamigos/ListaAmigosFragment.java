package com.house.domotic.my.mylogintest.views.home.listaamigos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.chat.ChatActivity;
import com.house.domotic.my.mylogintest.views.home.chatactivos.DeleteChatDialog;
import com.house.domotic.my.mylogintest.views.home.listaamigos.model.DeleteFriendDialog;
import com.house.domotic.my.mylogintest.views.home.listaamigos.model.ListaAmigosItemData;
import com.house.domotic.my.mylogintest.views.home.listaamigos.mvp.ListaAmigosContract;
import com.house.domotic.my.mylogintest.views.home.listaamigos.mvp.ListaAmigosPresenter;

import java.util.ArrayList;


public class ListaAmigosFragment extends Fragment implements
        ListaAmigosAdapter.OnItemChatClickListener,
        DeleteFriendDialog.OnFriendDialogClickListener,
        ListaAmigosContract.View, SwipeRefreshLayout.OnRefreshListener
    {

    private RecyclerView rv_fla_lista_amigo;

    private LinearLayoutManager mLayoutManager;

    private ListaAmigosAdapter listaAmigosAdapter;

    private ArrayList<ListaAmigosItemData> mDataset = new ArrayList<>();

    private int pos = -1;

    private ListaAmigosPresenter presenter;

    private SwipeRefreshLayout srl_fla_reload;

    public static ListaAmigosFragment newInstance() {
        ListaAmigosFragment fragment = new ListaAmigosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_amigos, container, false);

        presenter = new ListaAmigosPresenter(this);

        rv_fla_lista_amigo = view.findViewById(R.id.rv_fla_lista_amigo);
        srl_fla_reload = view.findViewById(R.id.srl_fla_reload);
        srl_fla_reload.setOnRefreshListener(this);

        // Instanciamos un linear layout manager para setearlo en el RecyclerView
        mLayoutManager = new LinearLayoutManager(getContext());

        rv_fla_lista_amigo.setLayoutManager(mLayoutManager);

        for (int i = 0; i < 10; i++) {
            mDataset.add(new ListaAmigosItemData("nombre " + i, "mensaje " + i, "foto " + i));
        }

        listaAmigosAdapter = new ListaAmigosAdapter(getContext(), mDataset);
        listaAmigosAdapter.setListener(this);


        rv_fla_lista_amigo.setAdapter(listaAmigosAdapter);



        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    public void onGoChat(ListaAmigosItemData listaAmigosItemData) {
        Intent intent = new Intent(this.getActivity(), ChatActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDeleteFriend(int pos) {
        this.pos = pos;
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        ft.addToBackStack(null);
        DeleteFriendDialog dialogFragment = new DeleteFriendDialog();
        dialogFragment.setListener(this);
        dialogFragment.show(ft, "dialog");
    }

    @Override
    public void onFriendAcept() {
        listaAmigosAdapter.deleteFriend(pos);
        pos = -1;
    }

            @Override
            public void getListaAmigosSuccess(ArrayList<ListaAmigosItemData> mDataset) {
                if (listaAmigosAdapter != null) {
                    listaAmigosAdapter.update(mDataset);
                    srl_fla_reload.setRefreshing(false);
                }
            }

            @Override
            public void getListaAmigosFailed() {

            }

            @Override
            public void onRefresh() {
                presenter.getListaAmigos();

            }
        }
