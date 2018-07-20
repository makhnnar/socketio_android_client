package com.house.domotic.my.mylogintest.views.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.chat.model.ChatItemData;
import com.house.domotic.my.mylogintest.views.home.chatactivos.model.ChatActivosItemData;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {


    private RecyclerView rv_ac_msg_List;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<ChatItemData> mDataset = new ArrayList<>();
    private ChatAdapter chatAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        rv_ac_msg_List = findViewById(R.id.rv_ac_msg_List);

        // Instanciamos un linear layout manager para setearlo en el RecyclerView
        mLayoutManager = new LinearLayoutManager(this.getBaseContext());

        rv_ac_msg_List.setLayoutManager(mLayoutManager);

        for(int i=0;i<10;i++){
            mDataset.add(new ChatItemData("nombre "+i,"mensaje "+i,"foto "+i, "hora"+i));
        }

        chatAdapter = new ChatAdapter(this.getBaseContext(), mDataset);

        rv_ac_msg_List.setAdapter(chatAdapter);


    }
}
