package com.example.rufflez.Cookbook.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rufflez.Cookbook.R;

import java.util.List;

/**
 * Created by rufflez on 10/4/15.
 */
public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.VersionViewHolder> {
    List<String> versionModels;
    Context context;

    public ShoppingListAdapter(Context context){
        this.context = context;
    }

    public ShoppingListAdapter(List<String> versionModels){
        this.versionModels = versionModels;
    }

    @Override
    public VersionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerlist_item, parent, false);
        VersionViewHolder viewHolder = new VersionViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ShoppingListAdapter.VersionViewHolder holder, int position) {
        holder.title.setText(versionModels.get(position));
    }

    @Override
    public int getItemCount() {
        return versionModels == null ? 0 : versionModels.size();
    }

    class VersionViewHolder extends RecyclerView.ViewHolder{
        CardView cardItemLayout;
        TextView title;

        public VersionViewHolder(View itemView){
            super(itemView);
            cardItemLayout = (CardView)itemView.findViewById(R.id.cardlist_item);
            title = (TextView)itemView.findViewById(R.id.listitem_name);
        }

    }
}
