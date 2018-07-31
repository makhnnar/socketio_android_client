package com.house.domotic.my.mylogintest.views.home.friendrequest;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import com.house.domotic.my.mylogintest.R;

public class AcceptFriendDialog extends DialogFragment implements View.OnClickListener{

    private OnDialogClickListener listener;

    private Button btn_afd_accept_friend_yes;
    private Button btn_afd_accept_friend_no;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.accept_friendship_dialog, container, false);

        btn_afd_accept_friend_yes = v.findViewById(R.id.btn_afd_accept_friend_yes);
        btn_afd_accept_friend_no = v.findViewById(R.id.btn_afd_accept_friend_no);

        btn_afd_accept_friend_yes.setOnClickListener(this);
        btn_afd_accept_friend_no.setOnClickListener(this);

        return v;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    public void setListener(OnDialogClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (view.equals(btn_afd_accept_friend_yes)){
            Log.i("pos", "---"+(listener != null));
            if (listener != null){
                Log.i("pos", "--- entro");
                listener.onAcept();
                this.dismiss();
            }
        }
        if (view.equals(btn_afd_accept_friend_no)){
            this.dismiss();
        }
    }

    public interface OnDialogClickListener {

        void onAcept();

    }
}

