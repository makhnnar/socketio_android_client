package com.house.domotic.my.mylogintest.views.home.chatactivos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.chat.ChatActivity;
import com.house.domotic.my.mylogintest.views.home.HomeActivity;
import com.house.domotic.my.mylogintest.views.home.chatactivos.model.ChatActivosItemData;


import java.util.ArrayList;

public class ChatActivosFragment extends Fragment implements ChatActivosAdapter.OnItemChatClickListener{

    private RecyclerView rv_fca_chat_activos;

    private LinearLayoutManager mLayoutManager;

    private ChatActivosAdapter chatActivosAdapter;

    private ArrayList<ChatActivosItemData> mDataset = new ArrayList<>();

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

        rv_fca_chat_activos = view.findViewById(R.id.rv_fca_chat_activos);

        // Instanciamos un linear layout manager para setearlo en el RecyclerView
        mLayoutManager = new LinearLayoutManager(getContext());

        rv_fca_chat_activos.setLayoutManager(mLayoutManager);

        for(int i=0;i<10;i++){
            mDataset.add(new ChatActivosItemData("nombre "+i,"mensaje "+i,"foto "+i));
        }

        chatActivosAdapter = new ChatActivosAdapter(getContext(), mDataset);
        chatActivosAdapter.setListener(this);

        rv_fca_chat_activos.setAdapter(chatActivosAdapter);

        return  view;
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
    public void onDeleteChat(ChatActivosItemData chatActivosItemData) {

    }
}
