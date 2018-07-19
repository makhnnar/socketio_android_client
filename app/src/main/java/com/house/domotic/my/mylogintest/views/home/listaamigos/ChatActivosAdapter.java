package com.house.domotic.my.mylogintest.views.home.listaamigos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.house.domotic.my.mylogintest.R;
import com.house.domotic.my.mylogintest.views.home.listaamigos.model.ListaAmigosItemData;

import java.util.ArrayList;

public class ChatActivosAdapter extends RecyclerView.Adapter<ChatActivosAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<ListaAmigosItemData> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        TextView tv_pli_ultimo_mensaje;
        TextView tv_pli_nombre_usuario;
        ImageView iv_pli_cancel;
        ImageView iv_pli_foto_user;

        ViewHolder(View v) {
            super(v);
            tv_pli_ultimo_mensaje = v.findViewById(R.id.tv_pli_ultimo_mensaje);
            tv_pli_nombre_usuario =  v.findViewById(R.id.tv_pli_nombre_usuario );
            iv_pli_cancel =  v.findViewById(R.id.iv_pli_cancel);
            iv_pli_foto_user =  v.findViewById(R.id.iv_pli_foto_user);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ChatActivosAdapter(Context context, ArrayList<ListaAmigosItemData> myDataset) {
        mDataset = myDataset;
        mContext = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ChatActivosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_list_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tv_pli_nombre_usuario.setText(mDataset.get(position).getNombre());
        holder.tv_pli_ultimo_mensaje.setText(mDataset.get(position).getEstado());

        //Glide.with(mContext).load(mDataset.get(position).getFoto()).into(holder.iv_pli_foto_user);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}