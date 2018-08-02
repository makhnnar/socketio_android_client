package com.house.domotic.my.mylogintest.views.home.profile;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.house.domotic.my.mylogintest.R;

public class ProfileDialog extends DialogFragment implements View.OnClickListener {

    private OnDialogClickListener listener;

    private ImageView ib_pd_go_profile;
    private ImageView ib_pd_go_chat;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.perfil_dialog, container, false);

        ib_pd_go_profile = v.findViewById(R.id.ib_pd_go_profile);
        ib_pd_go_chat = v.findViewById(R.id.ib_pd_go_chat);

        ib_pd_go_profile.setOnClickListener(this);
        ib_pd_go_chat.setOnClickListener(this);

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
        if (view.equals(ib_pd_go_profile)) {
            if (listener != null) {
                listener.onGoProfile();
                this.dismiss();
            }
        }
        if (view.equals(ib_pd_go_chat)) {
            if (listener != null) {
                listener.onGoChat();
                this.dismiss();

            }
        }
    }

    public interface OnDialogClickListener {

        void onGoProfile();

        void onGoChat();
    }
}
