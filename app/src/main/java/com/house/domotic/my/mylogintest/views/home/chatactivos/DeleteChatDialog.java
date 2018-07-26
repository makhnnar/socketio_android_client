package com.house.domotic.my.mylogintest.views.home.chatactivos;

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


public class DeleteChatDialog extends DialogFragment implements View.OnClickListener{

    private OnDialogClickListener listener;

    private Button btn_dcd_delete_chat_yes;
    private Button btn_dcd_delete_chat_no;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.delete_chat_dialog, container, false);

        btn_dcd_delete_chat_yes = v.findViewById(R.id.btn_dcd_delete_chat_yes);
        btn_dcd_delete_chat_no = v.findViewById(R.id.btn_dcd_delete_chat_no);

        btn_dcd_delete_chat_yes.setOnClickListener(this);
        btn_dcd_delete_chat_no.setOnClickListener(this);

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
        if (view.equals(btn_dcd_delete_chat_yes)){
            Log.i("pos", "---"+(listener != null));
            if (listener != null){
                Log.i("pos", "--- entro");
                listener.onAcept();
                this.dismiss();
            }
        }
        if (view.equals(btn_dcd_delete_chat_no)){
            this.dismiss();
        }
    }

    public interface OnDialogClickListener {

        void onAcept();
    }
}

