package com.example.rufflez.Cookbook.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.rufflez.Cookbook.activity.DetailFoodActivity;
import com.example.rufflez.myapplication.R;

import java.util.Arrays;
import java.util.List;

;

/**
 * Created by rufflez on 6/21/15.
 */
public class ShoppingListFragment extends Fragment {
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.shopping_fragment, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new SimpleStringRecyclerViewAdapter(getActivity(),
                Arrays.<String>asList(String.valueOf(DetailFoodActivity.trees))));
        Button btnDelAll = rootView.findViewById(R.id.btn_del_all);
        btnDelAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("Bạn muốn xóa tất cả không ?");
                builder.setCancelable(true);
                builder.setNegativeButton("Không!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.setPositiveButton("Vâng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        recyclerView.setAdapter(null);
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
        return rootView;
    }


    public static class SimpleStringRecyclerViewAdapter extends RecyclerView.Adapter<SimpleStringRecyclerViewAdapter.ViewHolder>{
        private List<String> mValues;
        private Context mContext;
        private boolean isBuy;

        public static class ViewHolder extends RecyclerView.ViewHolder {

            public final View mView;
            public final TextView mTextView;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mTextView = (TextView) view.findViewById(android.R.id.text1);
            }

        }

        public String getValueAt(int position) {
            return mValues.get(position);
        }

        public SimpleStringRecyclerViewAdapter(Context context, List<String> items) {
            mContext = context;
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(android.R.layout.simple_list_item_multiple_choice, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mTextView.setText(mValues.get(position));
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(isBuy){
                        holder.mTextView.setPaintFlags(holder.mTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                        holder.mTextView.setTextColor(Color.CYAN);
                        isBuy = false;
                    }else{
                        holder.mTextView.setPaintFlags(0);
                        holder.mTextView.setTextColor(Color.BLACK);
                        isBuy = true;
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }
    }
}
