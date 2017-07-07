package com.example.rufflez.Cookbook.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rufflez.Cookbook.R;
import com.example.rufflez.Cookbook.model.MonKhaiViModel;
import com.example.rufflez.Cookbook.model.MonSangModel;

import java.util.List;

/**
 * Created by mac-vuongvu on 6/27/17.
 */

public class MonKhaiViAdapter extends RecyclerView.Adapter<MonKhaiViAdapter.ViewHolder> {
    private Context context;
    private List<MonKhaiViModel> singleItemModelList;

    public MonKhaiViAdapter(Context context, List<MonKhaiViModel> foodModelList) {
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
        MonKhaiViModel singleItemModel = singleItemModelList.get(position);

        String image[] =  singleItemModel.getAvatarFood().split(",");
        byte[] decodebyte = Base64.decode(image[1], Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(decodebyte, 0, decodebyte.length);
        holder.foodimage.setImageBitmap(bitmap);
        holder.foodtile.setText(singleItemModel.getTitleFood());
         }

    @Override
    public int getItemCount() {
        return singleItemModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView foodtile;
        ImageView foodimage;
        public ViewHolder(View itemView) {
            super(itemView);
            foodimage = (ImageView) itemView.findViewById(R.id.itemImage);
            foodtile =  (TextView) itemView.findViewById(R.id.tvTitle);
        }
    }
}
