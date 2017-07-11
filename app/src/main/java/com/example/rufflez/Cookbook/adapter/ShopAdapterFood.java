package com.example.rufflez.Cookbook.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.rufflez.Cookbook.databases.FoodModel;
import com.example.rufflez.myapplication.R;

/**
 * Created by HoangLong on 7/11/2017.
 */

public class ShopAdapterFood extends RecyclerView.Adapter<ShopAdapterFood.ItemRowHolder> {
    private ArrayAdapter<FoodModel> foodModelList;
    private Context mContext;

    public ShopAdapterFood(ArrayAdapter<FoodModel> foodModelList, Context mContext) {
        this.foodModelList = foodModelList;
        this.mContext = mContext;
    }
    
    @Override
    public ItemRowHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ItemRowHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView itemTitle;

        protected RecyclerView recycler_view_list;

        protected Button btnMore;

        public ItemRowHolder(View view) {
            super(view);

            this.itemTitle = (TextView) view.findViewById(R.id.title_header);
            this.recycler_view_list = (RecyclerView) view.findViewById(R.id.recycle_view_nguyen_lieu);
            this.btnMore = (Button) view.findViewById(R.id.buttonNau);
        }

    }
}
