package com.example.rufflez.Cookbook.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rufflez.Cookbook.DetailFoodActivity;
import com.example.rufflez.Cookbook.model.MonSangModel;
import com.example.rufflez.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac-vuongvu on 6/27/17.
 */

public class MonSangAdapter extends RecyclerView.Adapter<MonSangAdapter.ViewHolder> {
    private Context context;
    private List<MonSangModel> singleItemModelList = new ArrayList<MonSangModel>();

    public MonSangAdapter(Context context, List<MonSangModel> foodModelList) {
        this.context = context;
        this.singleItemModelList = foodModelList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_in_type_food, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MonSangModel singleItemModel = singleItemModelList.get(position);

        String image[] =  singleItemModel.getAvatarFood().split(",");
        byte[] decodebyte = Base64.decode(image[1], Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodebyte, 0, decodebyte.length);
//        holder.textView_detail.setText(singleItemModel.getTitleFood());
        holder.foodimage.setImageBitmap(bitmap);
        holder.foodtile.setText(singleItemModel.getTitleFood());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailFoodActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("singleItemModel", singleItemModel);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
         }

    @Override
    public int getItemCount() {
        return singleItemModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView foodtile;
        ImageView foodimage;
        TextView textView_detail;
        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            foodimage = (ImageView) itemView.findViewById(R.id.itemImage);
            foodtile =  (TextView) itemView.findViewById(R.id.tvTitle);
            textView_detail = (TextView) itemView.findViewById(R.id.tv_detail);
            cardView = (CardView) itemView.findViewById(R.id.card_view);
        }
    }
}
