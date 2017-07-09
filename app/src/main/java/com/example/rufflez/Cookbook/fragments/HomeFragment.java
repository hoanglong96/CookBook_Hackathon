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
import android.widget.TextView;

import com.example.rufflez.Cookbook.MoreActivity;
import com.example.rufflez.Cookbook.adapter.FoodAdapter;
import com.example.rufflez.Cookbook.databases.DatabaseHandle;
import com.example.rufflez.Cookbook.utils.Utils;
import com.example.rufflez.myapplication.R;

/**
 * Created by rufflez on 6/20/15.
 */
public class HomeFragment extends Fragment {
    TextView btnMoreAnSang, btnMoreKhaiVi, btnMoreTrangMieng, btnMoreMonChinh;

    RecyclerView mRecycleView_an_sang, mRecycleView_khai_vi, mRecycleView_mon_chinh, mRecycleView_trang_mieng;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        mRecycleView_an_sang = rootView.findViewById(R.id.recycler_view_list_an_sang);
        mRecycleView_khai_vi = rootView.findViewById(R.id.recycler_view_list_khai_vi);
        mRecycleView_mon_chinh = rootView.findViewById(R.id.recycler_view_list_mon_chinh);
        mRecycleView_trang_mieng = rootView.findViewById(R.id.recycler_view_list_mon_trang_mieng);

        btnMoreAnSang = rootView.findViewById(R.id.btnMore_an_sang);
        btnMoreKhaiVi = rootView.findViewById(R.id.btnMore_khai_vi);
        btnMoreMonChinh = rootView.findViewById(R.id.btnMore_mon_chinh);
        btnMoreTrangMieng = rootView.findViewById(R.id.btnMore_mon_trang_mieng);

        btnMoreAnSang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MoreActivity.class);
                startActivity(intent);
            }
        });
        btnMoreKhaiVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MoreActivity.class);
                startActivity(intent);
            }
        });

        btnMoreMonChinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MoreActivity.class);
                startActivity(intent);
            }
        });

        btnMoreTrangMieng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MoreActivity.class);
                startActivity(intent);
            }
        });


        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // recyclerview
        LinearLayoutManager layoutManagerAnSang = new LinearLayoutManager(
                getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerMonKhaiVi = new LinearLayoutManager(
                getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerMonChinh = new LinearLayoutManager(
                getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerTrangMieng = new LinearLayoutManager(
                getActivity(), LinearLayoutManager.HORIZONTAL, false);

        mRecycleView_an_sang.setLayoutManager(layoutManagerAnSang);
        mRecycleView_khai_vi.setLayoutManager(layoutManagerMonChinh);
        mRecycleView_mon_chinh.setLayoutManager(layoutManagerMonKhaiVi);
        mRecycleView_trang_mieng.setLayoutManager(layoutManagerTrangMieng);
        createAdapter();

        super.onViewCreated(view, savedInstanceState);
    }
    public void createAdapter() {
        mRecycleView_an_sang.hasFixedSize();
        mRecycleView_mon_chinh.hasFixedSize();
        mRecycleView_trang_mieng.hasFixedSize();
        mRecycleView_khai_vi.hasFixedSize();

        FoodAdapter monSangAdapter  = new FoodAdapter(getContext(), Utils.loclist(DatabaseHandle.getHandle(getContext()).getListFood(), "Món sáng"));
        mRecycleView_an_sang.setAdapter(monSangAdapter);
        FoodAdapter monSangAdapter2  = new FoodAdapter(getContext(), Utils.loclist(DatabaseHandle.getHandle(getContext()).getListFood(), "Món khai vị"));
        mRecycleView_khai_vi.setAdapter(monSangAdapter2);
        FoodAdapter monSangAdapter3  = new FoodAdapter(getContext(), Utils.loclist(DatabaseHandle.getHandle(getContext()).getListFood(), "Món chính"));
        mRecycleView_mon_chinh.setAdapter(monSangAdapter3);
        FoodAdapter monSangAdapter4 = new FoodAdapter(getContext(), Utils.loclist(DatabaseHandle.getHandle(getContext()).getListFood(), "Món tráng miệng"));
        mRecycleView_trang_mieng.setAdapter(monSangAdapter4);

    }
}

