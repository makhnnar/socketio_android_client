package com.house.domotic.my.mylogintest.views.home.friendrequest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.home.friendrequest.model.FriendRequestItemData;

import java.util.ArrayList;

public class FriendRequestAdapter extends RecyclerView.Adapter<FriendRequestAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<FriendRequestItemData> mDataset;
    private OnFriendRequestClickListener listener;


    static class ViewHolder extends RecyclerView.ViewHolder {


        TextView tv_pfr_mensaje;
        TextView tv_pfr_nombre_usuario;
        TextView tv_pfr_hora;
        ImageView iv_pfr_foto_user;
        ImageView iv_pfr_accept_friend;
        ImageView iv_pfr_decline_friend;

        ViewHolder(View v) {
            super(v);
            tv_pfr_mensaje = v.findViewById(R.id.tv_pfr_mensaje);
            tv_pfr_nombre_usuario = v.findViewById(R.id.tv_pfr_nombre_usuario);
            tv_pfr_hora = v.findViewById(R.id.tv_pfr_hora);
            iv_pfr_foto_user = v.findViewById(R.id.iv_pfr_foto_user);
            iv_pfr_accept_friend = v.findViewById(R.id.iv_pfr_accept_friend);
            iv_pfr_decline_friend = v.findViewById(R.id.iv_pfr_decline_friend);
        }
    }


    public FriendRequestAdapter(Context context, ArrayList<FriendRequestItemData> myDataset) {
        mDataset = myDataset;
        mContext = context;
    }


    @Override
    public FriendRequestAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_friend_request, parent, false);


        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tv_pfr_nombre_usuario.setText(mDataset.get(position).getNombre());
        holder.tv_pfr_mensaje.setText(mDataset.get(position).getMensaje());
        holder.tv_pfr_hora.setText(mDataset.get(position).getHora());
        holder.iv_pfr_accept_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onAcceptFriendship(position);
                }
            }
        });
        holder.iv_pfr_decline_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (listener != null) {
                        listener.onDeclineFriendship(position);

                    }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void setListener(OnFriendRequestClickListener listener) {
            this.listener = listener;
    }

    public interface OnFriendRequestClickListener {
        void onAcceptFriendship(int pos);

        void onDeclineFriendship(int pos);
    }
    public void update(ArrayList<FriendRequestItemData> mDataset){
        if (mDataset != null){
            this.mDataset  = mDataset;
            notifyDataSetChanged();


        }

    }

}


   /* public void deleteFriend(int position) {
        if (position > -1) {
            mDataset.remove(position);
            notifyDataSetChanged();
        }
    }








    public void update(ArrayList<ListaAmigosItemData> mDataset) {
        if (mDataset != null) {
            this.mDataset.clear();
            this.mDataset = mDataset;
            notifyDataSetChanged();
        }
    }
}*/

