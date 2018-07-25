package com.house.domotic.my.mylogintest.views.home.listaamigos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.home.chatactivos.ChatActivosAdapter;
import com.house.domotic.my.mylogintest.views.home.listaamigos.model.ListaAmigosItemData;

import java.util.ArrayList;

public class ListaAmigosAdapter extends RecyclerView.Adapter<ListaAmigosAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<ListaAmigosItemData> mDataset;
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


    public ListaAmigosAdapter(Context context, ArrayList<ListaAmigosItemData> myDataset) {
        mDataset = myDataset;
        mContext = context;
    }


    @Override
    public ListaAmigosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_list_item, parent, false);


        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tv_pli_nombre_usuario.setText(mDataset.get(position).getNombre());
        holder.tv_pli_ultimo_mensaje.setText(mDataset.get(position).getEstado());
        //Glide.with(mContext).load(mDataset.get(position).getFoto()).into(holder.iv_pli_foto_user);
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
                    listener.onDeleteFriend(mDataset.get(position));
                }
            }
        });

    }


    @Override
    public int getItemCount () {
        return mDataset.size();
    }

    public void setListener (OnItemChatClickListener listener){
        this.listener = listener;
    }

    public interface OnItemChatClickListener {
        void onGoChat(ListaAmigosItemData listaAmigosItemData);
        void onDeleteFriend(ListaAmigosItemData listaAmigosItemData);
    }
    }