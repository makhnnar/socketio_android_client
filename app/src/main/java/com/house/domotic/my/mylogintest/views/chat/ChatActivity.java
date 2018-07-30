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
import com.house.domotic.my.mylogintest.views.chat.mvp.ChatContract;
import com.house.domotic.my.mylogintest.views.chat.mvp.ChatPresenter;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity implements
        View.OnClickListener, ChatContract.View {


    private RecyclerView rv_ac_msg_List;
    private LinearLayoutManager mLayoutManager;
    private ArrayList<ChatItemData> mDataset = new ArrayList<>();
    private ChatAdapter chatAdapter;
    private ImageView iv_ac_send_button;
    private EditText et_ac_send_text;
    private ImageView iv_ac_arrow_back;
    private ChatPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        rv_ac_msg_List = findViewById(R.id.rv_ac_msg_List);
        iv_ac_send_button = findViewById(R.id.iv_ac_send_button);
        iv_ac_send_button.setOnClickListener(this);
        et_ac_send_text = findViewById(R.id.et_ac_send_text);
        iv_ac_arrow_back = findViewById(R.id.iv_ac_arrow_back);
        iv_ac_arrow_back.setOnClickListener(this);


        // Instanciamos un linear layout manager para setearlo en el RecyclerView
        mLayoutManager = new LinearLayoutManager(this.getBaseContext());

        presenter = new ChatPresenter(this);

        rv_ac_msg_List.setLayoutManager(mLayoutManager);

        /*for(int i=0;i<10;i++){
            mDataset.add(new ChatItemData("nombre "+i,"mensaje "+i,"foto "+i, "hora"+i));
        }*/

        chatAdapter = new ChatAdapter(this.getBaseContext(), mDataset);

        rv_ac_msg_List.setAdapter(chatAdapter);

        presenter.getAllMessage();

    }

    @Override
    public void onClick(View view) {
        if (view.equals(iv_ac_send_button)) {

            //chatAdapter.showLastMessage(chatItemData);

            presenter.sendMessage(et_ac_send_text.getText().toString());
            et_ac_send_text.setText("");

        }
        if (view.equals(iv_ac_arrow_back)) {
            onBackPressed();
        }

    }

    @Override
    public void onReciveAllMessagesSuccess(ArrayList<ChatItemData> mDataset) {
        if (chatAdapter != null) {
            chatAdapter.update(mDataset);
            rv_ac_msg_List.smoothScrollToPosition(chatAdapter.getItemCount() - 1);
        }
    }

    @Override
    public void onReciveMessageSuccess() {

    }

    @Override
    public void onReciveAllMessagesFailed() {

    }

    @Override
    public void onReciveMessageFailed() {

    }
}
