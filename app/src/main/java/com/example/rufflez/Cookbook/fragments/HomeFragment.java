package com.example.rufflez.Cookbook.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.rufflez.Cookbook.MoreActivity;
import com.example.rufflez.Cookbook.R;
import com.example.rufflez.Cookbook.adapter.CardViewListDataAdapter;
import com.example.rufflez.Cookbook.model.ItemInTypeFoodModel;

import java.util.ArrayList;

/**
 * Created by rufflez on 6/20/15.
 */
public class HomeFragment extends Fragment{
    ArrayList<ItemInTypeFoodModel> singleItemAnSang = new ArrayList<ItemInTypeFoodModel>();
    ArrayList<ItemInTypeFoodModel> singleItemKhaiVi = new ArrayList<ItemInTypeFoodModel>();
    ArrayList<ItemInTypeFoodModel> singleItemMonChinh = new ArrayList<ItemInTypeFoodModel>();
    ArrayList<ItemInTypeFoodModel> singleItemTrangMieng = new ArrayList<ItemInTypeFoodModel>();

    RelativeLayout btnMoreAnSang,btnMoreKhaiVi,btnMoreTrangMieng,btnMoreMonChinh;

    RecyclerView mRecycleView_an_sang,mRecycleView_khai_vi,mRecycleView_mon_chinh,mRecycleView_trang_mieng;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        mRecycleView_an_sang =  rootView.findViewById(R.id.recycler_view_list_an_sang);
        mRecycleView_khai_vi = rootView.findViewById(R.id.recycler_view_list_khai_vi);
        mRecycleView_mon_chinh = rootView.findViewById(R.id.recycler_view_list_mon_chinh);
        mRecycleView_trang_mieng = rootView.findViewById(R.id.recycler_view_list_mon_trang_mieng);

        btnMoreAnSang = rootView.findViewById(R.id.btn_an_sang);
        btnMoreKhaiVi = rootView.findViewById(R.id.btn_mon_khai_vi);
        btnMoreMonChinh = rootView.findViewById(R.id.btn_mon_chinh);
        btnMoreTrangMieng = rootView.findViewById(R.id.btn_mon_trang_mieng);

        btnMoreAnSang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MoreActivity.class);
                startActivity(intent);
            }
        });
        btnMoreKhaiVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MoreActivity.class);
                startActivity(intent);
            }
        });

        btnMoreMonChinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MoreActivity.class);
                startActivity(intent);
            }
        });

        btnMoreTrangMieng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MoreActivity.class);
                startActivity(intent);
            }
        });


        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // recyclerview
        LinearLayoutManager layoutManagerAnSang = new LinearLayoutManager(
                getActivity(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManagerMonKhaiVi = new LinearLayoutManager(
                getActivity(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManagerMonChinh = new LinearLayoutManager(
                getActivity(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManagerTrangMieng = new LinearLayoutManager(
                getActivity(),LinearLayoutManager.HORIZONTAL,false);

        mRecycleView_an_sang.setLayoutManager(layoutManagerAnSang);
        mRecycleView_khai_vi.setLayoutManager(layoutManagerMonChinh);
        mRecycleView_mon_chinh.setLayoutManager(layoutManagerMonKhaiVi);
        mRecycleView_trang_mieng.setLayoutManager(layoutManagerTrangMieng);

        createDummyData();

        CardViewListDataAdapter adapterAnSang = new CardViewListDataAdapter(getActivity(), singleItemAnSang);
        CardViewListDataAdapter adapterKhaiVi = new CardViewListDataAdapter(getActivity(), singleItemKhaiVi);
        CardViewListDataAdapter adapterMonChinh = new CardViewListDataAdapter(getActivity(), singleItemMonChinh);
        CardViewListDataAdapter adapterTrangMieng = new CardViewListDataAdapter(getActivity(), singleItemTrangMieng);

        mRecycleView_an_sang.setAdapter(adapterAnSang);
        mRecycleView_khai_vi.setAdapter(adapterKhaiVi);
        mRecycleView_trang_mieng.setAdapter(adapterTrangMieng);
        mRecycleView_mon_chinh.setAdapter(adapterMonChinh);

        super.onViewCreated(view, savedInstanceState);
    }

    public void createDummyData() {
            for (int j = 0; j <= 5; j++) {
                singleItemAnSang.add(new ItemInTypeFoodModel("Item " + j, "URL " + j));
                singleItemKhaiVi.add(new ItemInTypeFoodModel("Item " + j, "URL " + j));
                singleItemTrangMieng.add(new ItemInTypeFoodModel("Item " + j, "URL " + j));
                singleItemMonChinh.add(new ItemInTypeFoodModel("Item " + j, "URL " + j));
            }
        }
    }

