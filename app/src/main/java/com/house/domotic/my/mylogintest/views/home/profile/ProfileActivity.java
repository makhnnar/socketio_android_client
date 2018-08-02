package com.house.domotic.my.mylogintest.views.home.profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.chat.ChatActivity;
import com.house.domotic.my.mylogintest.views.home.profile.model.ProfileItemData;
import com.house.domotic.my.mylogintest.views.home.profile.mvp.ProfileContract;
import com.house.domotic.my.mylogintest.views.home.profile.mvp.ProfilePresenter;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener,
        ProfileContract.View
{


    private ArrayList<ProfileItemData> mDataset = new ArrayList<>();

    private ImageView iv_ap_message_friend;
    private ImageView iv_ap_decline_friend;
    private ImageView iv_ap_accept_friend;
    private ImageView iv_ap_foto_user;
    private ImageView iv_ap_arrow_back;
    private ProfilePresenter presenter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        iv_ap_message_friend = findViewById(R.id.iv_ap_message_friend);
        iv_ap_message_friend.setOnClickListener(this);
        iv_ap_decline_friend = findViewById(R.id.iv_ap_decline_friend);
        iv_ap_decline_friend.setOnClickListener(this);
        iv_ap_accept_friend = findViewById(R.id.iv_ap_accept_friend);
        iv_ap_accept_friend.setOnClickListener(this);
        iv_ap_foto_user = findViewById(R.id.iv_ap_foto_user);
        iv_ap_foto_user.setOnClickListener(this);
        iv_ap_arrow_back = findViewById(R.id.iv_ap_arrow_back);
        iv_ap_arrow_back.setOnClickListener(this);

        // Instanciamos un linear layout manager para setearlo en el RecyclerView


        presenter = new ProfilePresenter(this);

        presenter.getViewProfile();



        /*for(int i=0;i<10;i++){
            mDataset.add(new ProfileItemData("nombre "+i,"mensaje "+i,"foto "+i, "hora"+i));
        }*/







    }


    @Override
    public void onClick(View view) {
        if (view.equals(iv_ap_message_friend)){
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }

        if (view.equals(iv_ap_arrow_back)) {
            onBackPressed();
        }

    }

    @Override
    public void onReciveProfileSuccess(ArrayList<ProfileItemData> mDataset) {

    }

    @Override
    public void onReciveProfileFailed() {

    }


}

