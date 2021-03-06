package com.house.domotic.my.mylogintest.views.chat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.chat.model.ChatItemData;
import com.house.domotic.my.mylogintest.views.home.profile.ProfileDialog;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<ChatItemData> mDataset;
    private OnFotoChatCLickListener listener;



    static class ViewHolder extends RecyclerView.ViewHolder {


        TextView tv_pcli_nombre_usuario;
        TextView tv_pcli_hora;
        TextView tv_pcli_mensaje;
        ImageView iv_pcli_foto_user;


        ViewHolder(View v) {
            super(v);
            tv_pcli_nombre_usuario = v.findViewById(R.id.tv_pcli_nombre_usuario);
            tv_pcli_hora =  v.findViewById(R.id.tv_pcli_hora );
            tv_pcli_mensaje =  v.findViewById(R.id.tv_pcli_mensaje);
            iv_pcli_foto_user =  v.findViewById(R.id.iv_pcli_foto_user);
            }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ChatAdapter(Context context, ArrayList<ChatItemData> myDataset) {
        mDataset = myDataset;
        mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ChatAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_chat_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder,  int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        Log.i("hola", "onBindViewHolder: Nombre " + mDataset.get(position).getNombre() );
        Log.i("hola", "onBindViewHolder: Mensaje " + mDataset.get(position).getMensaje());
        Log.i("hola", "onBindViewHolder: Hora " + mDataset.get(position).getHora());
        Log.i("hola", "onBindViewHolder: Foto " + mDataset.get(position).getFoto());
        Log.i("hola", "onBindViewHolder: Id " + mDataset.get(position).getId());

        holder.tv_pcli_nombre_usuario.setText(mDataset.get(position).getNombre());
        holder.tv_pcli_mensaje.setText(mDataset.get(position).getMensaje());
        holder.tv_pcli_hora.setText(mDataset.get(position).getHora());
        Glide.with(mContext).load(mDataset.get(position).getFoto()).into(holder.iv_pcli_foto_user);

    }

    public interface OnFotoChatCLickListener{

        void onGoProfileDialog(int pos);


    }
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public void showLastMessage (ChatItemData chatItemData){
        mDataset.add(chatItemData);
        notifyDataSetChanged();
    }

    public void update (ArrayList<ChatItemData> messageList){
        if (messageList != null  && messageList.size() > 0){
            //this.mDataset.clear();
            this.mDataset  = messageList;
            notifyDataSetChanged();
        }
    }
}

