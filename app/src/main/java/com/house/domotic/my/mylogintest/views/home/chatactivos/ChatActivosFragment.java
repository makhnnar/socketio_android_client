package com.house.domotic.my.mylogintest.views.home.chatactivos;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.chat.ChatActivity;

import com.house.domotic.my.mylogintest.views.home.chatactivos.model.ChatActivosItemData;
import com.house.domotic.my.mylogintest.views.home.chatactivos.mvp.ChatActivosContract;
import com.house.domotic.my.mylogintest.views.home.chatactivos.mvp.ChatActivosPresenter;


import java.util.ArrayList;

public class ChatActivosFragment extends Fragment implements
        ChatActivosAdapter.OnItemChatClickListener,
        DeleteChatDialog.OnDialogClickListener,
        ChatActivosContract.View{

    private RecyclerView rv_fca_chat_activos;

    private LinearLayoutManager mLayoutManager;

    private ChatActivosAdapter chatActivosAdapter;

    private ArrayList<ChatActivosItemData> mDataset = new ArrayList<>();

    private int pos = -1;

    private ChatActivosPresenter presenter;

    public static ChatActivosFragment newInstance() {
        ChatActivosFragment fragment = new ChatActivosFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chat_activos, container, false);

        presenter = new ChatActivosPresenter(this);

        rv_fca_chat_activos = view.findViewById(R.id.rv_fca_chat_activos);

        // Instanciamos un linear layout manager para setearlo en el RecyclerView
        mLayoutManager = new LinearLayoutManager(getContext());

        rv_fca_chat_activos.setLayoutManager(mLayoutManager);


        chatActivosAdapter = new ChatActivosAdapter(getContext(), mDataset);
        chatActivosAdapter.setListener(this);

        rv_fca_chat_activos.setAdapter(chatActivosAdapter);
        presenter.getChatActivos();

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

    @Override
    public void onGoChat(ChatActivosItemData chatActivosItemData) {
        Intent intent = new Intent(this.getActivity(), ChatActivity.class);
        startActivity(intent);
    }

    @Override
    public void onDeleteChat(int pos) {
        this.pos = pos;
        FragmentTransaction ft = this.getFragmentManager().beginTransaction();
        Fragment prev = getFragmentManager().findFragmentByTag("dialog");
        ft.addToBackStack(null);
        DeleteChatDialog dialogFragment = new DeleteChatDialog();
        dialogFragment.setListener(this);
        dialogFragment.show(ft, "dialog");
        Log.i("pos", "--- "+pos);
    }

    @Override
    public void onAcept() {
        chatActivosAdapter.deleteChatActivo(pos);
        pos = -1;
    }

    @Override
    public void getChatActivosSuccess(ArrayList<ChatActivosItemData> mDataset) {
        if (chatActivosAdapter != null) {
            chatActivosAdapter.update(mDataset);
        }

    }

    @Override
    public void getChatActivosFailed() {

    }
}
