package com.house.domotic.my.mylogintest.views.home.friendrequest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.chat.ChatActivity;
import com.house.domotic.my.mylogintest.views.home.HomeActivity;
import com.house.domotic.my.mylogintest.views.home.friendrequest.model.FriendRequestItemData;
import com.house.domotic.my.mylogintest.views.home.friendrequest.mvp.FriendRequestContract;
import com.house.domotic.my.mylogintest.views.home.friendrequest.mvp.FriendRequestPresenter;
import com.house.domotic.my.mylogintest.views.home.profile.ProfileActivity;
import com.house.domotic.my.mylogintest.views.home.profile.ProfileDialog;

import java.util.ArrayList;

public class FriendRequestFragment extends Fragment implements
             FriendRequestContract.View,
             SwipeRefreshLayout.OnRefreshListener,
             FriendRequestAdapter.OnFriendRequestClickListener,
            DeclineFriendDialog.OnDialogClickListener,
            AcceptFriendDialog.OnDialogClickListener,
            ProfileDialog.OnDialogClickListener
{

    private RecyclerView rv_ffr_petitions;

    private LinearLayoutManager mLayoutManager;

    private FriendRequestAdapter friendRequestAdapter;

    private ArrayList<FriendRequestItemData> mDataset = new ArrayList<>();

    private int pos = -1;

    private FriendRequestPresenter presenter;

    private SwipeRefreshLayout srl_ffr_reload;

    public static FriendRequestFragment newInstance() {
        FriendRequestFragment fragment = new FriendRequestFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_frienship_request, container, false);

        presenter = new FriendRequestPresenter(this);

        rv_ffr_petitions = view.findViewById(R.id.rv_ffr_petitions);
        srl_ffr_reload = view.findViewById(R.id.srl_ffr_reload);
        srl_ffr_reload.setOnRefreshListener(this);

        // Instanciamos un linear layout manager para setearlo en el RecyclerView
        mLayoutManager = new LinearLayoutManager(getContext());

        rv_ffr_petitions.setLayoutManager(mLayoutManager);

        for (int i = 0; i < 10; i++) {
            mDataset.add(new FriendRequestItemData("nombre " + i, "mensaje " + i, "foto " + i, "hora" + i));
        }

        friendRequestAdapter = new FriendRequestAdapter(getContext(), mDataset);
        friendRequestAdapter.setListener(this);


        rv_ffr_petitions.setAdapter(friendRequestAdapter);
        presenter.getAllFrienshipNotifications();



        return view;
    }
    @Override
    public void onFriendRequestSuccess(ArrayList<FriendRequestItemData> mDataset) {

    }

    @Override
    public void onFriendRequestFailed() {

    }

    @Override
    public void onFriendRequestListFailed() {

    }

    @Override
    public void onAcceptFriendship(int pos) {
        this.pos = pos;
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        ft.addToBackStack(null);
        AcceptFriendDialog dialogFragment = new AcceptFriendDialog();
        dialogFragment.setListener(this);
        dialogFragment.show(ft, "dialog");
        Log.i("pos", "--- "+pos);

    }

    @Override
    public void onDeclineFriendship(int pos) {
        this.pos = pos;
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        ft.addToBackStack(null);
        DeclineFriendDialog dialogFragment = new DeclineFriendDialog();
        dialogFragment.setListener(this);
        dialogFragment.show(ft, "dialog");
        Log.i("pos", "--- "+pos);

    }

    @Override
    public void onViewProfile(int pos) {
        this.pos = pos;
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        ft.addToBackStack(null);
        ProfileDialog dialogFragment = new ProfileDialog();
        dialogFragment.setListener(this);
        dialogFragment.show(ft, "dialog");
        Log.i("pos", "--- "+pos);

    }

    @Override
    public void onFriendRequestListSuccess(ArrayList<FriendRequestItemData> mDataset) {
        if (friendRequestAdapter != null) {
            friendRequestAdapter.update(mDataset);
            srl_ffr_reload.setRefreshing(false);
        }
    }

    @Override
    public void onRefresh() {
        presenter.getAllFrienshipNotifications();

    }


    @Override
    public void onAcept() {



    }

    @Override
    public void onDecline() {
        friendRequestAdapter.deleteFrienshipRequest(pos);
        pos = -1;

    }

    @Override
    public void onGoProfile() {
        Intent intent = new Intent(this.getActivity(), ProfileActivity.class);
        startActivity(intent);

    }

    @Override
    public void onGoChat() {
        Intent intent = new Intent(this.getActivity(), ChatActivity.class);
        startActivity(intent);

    }



   /* @Override
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
    public void getListaAmigosFailed() {

    }

    */
}


