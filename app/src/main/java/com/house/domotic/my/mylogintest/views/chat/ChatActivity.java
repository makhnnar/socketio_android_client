package com.house.domotic.my.mylogintest.views.chat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.chat.model.ChatItemData;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener{


    private RecyclerView rv_ac_msg_List;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<ChatItemData> mDataset = new ArrayList<>();
    private ChatAdapter chatAdapter;
    private ImageView iv_ac_send_button;
    private EditText et_ac_send_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        rv_ac_msg_List = findViewById(R.id.rv_ac_msg_List);
        iv_ac_send_button = findViewById(R.id.iv_ac_send_button);
        iv_ac_send_button.setOnClickListener(this);
        et_ac_send_text =findViewById(R.id.et_ac_send_text);


        // Instanciamos un linear layout manager para setearlo en el RecyclerView
        mLayoutManager = new LinearLayoutManager(this.getBaseContext());

        rv_ac_msg_List.setLayoutManager(mLayoutManager);

        for(int i=0;i<10;i++){
            mDataset.add(new ChatItemData("nombre "+i,"mensaje "+i,"foto "+i, "hora"+i));
        }

        chatAdapter = new ChatAdapter(this.getBaseContext(), mDataset);

        rv_ac_msg_List.setAdapter(chatAdapter);


    }

    @Override
    public void onClick(View view) {
        if(view.equals(iv_ac_send_button)){
            ChatItemData chatItemData = new ChatItemData(et_ac_send_text.getText());

            
        }

    }
}
