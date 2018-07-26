package com.house.domotic.my.mylogintest.views.home.chatactivos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.home.chatactivos.model.ChatActivosItemData;
import com.house.domotic.my.mylogintest.views.home.listaamigos.model.ListaAmigosItemData;

import java.util.ArrayList;

public class ChatActivosAdapter extends RecyclerView.Adapter<ChatActivosAdapter.ViewHolder>{

    private Context mContext;
    private ArrayList<ChatActivosItemData> mDataset;
    private OnItemChatClickListener listener;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_pli_ultimo_mensaje;
        TextView tv_pli_nombre_usuario;
        ImageView iv_pli_cancel;
        ImageView iv_pli_foto_user;

        ViewHolder(View v) {
            super(v);
            tv_pli_ultimo_mensaje = v.findViewById(R.id.tv_pli_ultimo_mensaje);
            tv_pli_nombre_usuario = v.findViewById(R.id.tv_pli_nombre_usuario);
            iv_pli_cancel = v.findViewById(R.id.iv_pli_cancel);
            iv_pli_foto_user = v.findViewById(R.id.iv_pli_foto_user);
        }
    }


    public ChatActivosAdapter(Context context, ArrayList<ChatActivosItemData> myDataset) {
        mDataset = myDataset;
        mContext = context;
    }


    @Override
    public ChatActivosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_list_item, parent, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tv_pli_nombre_usuario.setText(mDataset.get(position).getNombre());
        holder.tv_pli_ultimo_mensaje.setText(mDataset.get(position).getMensaje());
        holder.tv_pli_nombre_usuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    listener.onGoChat(mDataset.get(position));
                }
            }
        });
        holder.iv_pli_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null){
                    listener.onDeleteChat(position);
                }
            }
        });
        //Glide.with(mContext).load(mDataset.get(position).getFoto()).into(holder.iv_pli_foto_user);

    }

    public void deleteChatActivo(int position){
        if(position > -1) {
            mDataset.remove(position);
            notifyDataSetChanged();
        }
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setListener(OnItemChatClickListener listener) {
        this.listener = listener;
    }

    public interface OnItemChatClickListener {
        void onGoChat(ChatActivosItemData chatActivosItemData);
        void onDeleteChat(int pos);
    }
    public void update(ArrayList<ChatActivosItemData> mDataset){
        if (mDataset != null){
            this.mDataset.clear();
            this.mDataset  = mDataset;
            notifyDataSetChanged();


        }

    }

}