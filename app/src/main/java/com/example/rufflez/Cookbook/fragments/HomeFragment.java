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
<<<<<<< HEAD
import android.widget.TextView;

import com.example.rufflez.Cookbook.MoreActivity;
import com.example.rufflez.Cookbook.R;
import com.example.rufflez.Cookbook.adapter.MonChinhAdapter;
import com.example.rufflez.Cookbook.adapter.MonKhaiViAdapter;
import com.example.rufflez.Cookbook.adapter.MonSangAdapter;
import com.example.rufflez.Cookbook.adapter.MonTrangMiengAdapter;
import com.example.rufflez.Cookbook.databases.DataHandle;
import com.example.rufflez.Cookbook.model.MonChinhModel;
import com.example.rufflez.Cookbook.model.MonKhaiViModel;
import com.example.rufflez.Cookbook.model.MonSangModel;
import com.example.rufflez.Cookbook.model.MonTrangMiengModel;
=======

import com.example.rufflez.Cookbook.MoreActivity;
import com.example.rufflez.Cookbook.R;
import com.example.rufflez.Cookbook.adapter.CardViewListDataAdapter;
import com.example.rufflez.Cookbook.model.ItemInTypeFoodModel;
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b

import java.util.ArrayList;

/**
 * Created by rufflez on 6/20/15.
 */
<<<<<<< HEAD
public class HomeFragment extends Fragment {
    ArrayList<MonSangModel> singleItemAnSang = new ArrayList<MonSangModel>();
    ArrayList<MonChinhModel> singleItemKhaiVi = new ArrayList<>();
    ArrayList<MonKhaiViModel> singleItemMonChinh = new ArrayList<>();
    ArrayList<MonTrangMiengModel> singleItemTrangMieng = new ArrayList<>();

    TextView btnMoreAnSang, btnMoreKhaiVi, btnMoreTrangMieng, btnMoreMonChinh;

    RecyclerView mRecycleView_an_sang, mRecycleView_khai_vi, mRecycleView_mon_chinh, mRecycleView_trang_mieng;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        mRecycleView_an_sang = rootView.findViewById(R.id.recycler_view_list_an_sang);
=======
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
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
        mRecycleView_khai_vi = rootView.findViewById(R.id.recycler_view_list_khai_vi);
        mRecycleView_mon_chinh = rootView.findViewById(R.id.recycler_view_list_mon_chinh);
        mRecycleView_trang_mieng = rootView.findViewById(R.id.recycler_view_list_mon_trang_mieng);

<<<<<<< HEAD
        btnMoreAnSang = rootView.findViewById(R.id.btnMore_an_sang);
        btnMoreKhaiVi = rootView.findViewById(R.id.btnMore_khai_vi);
        btnMoreMonChinh = rootView.findViewById(R.id.btnMore_mon_chinh);
        btnMoreTrangMieng = rootView.findViewById(R.id.btnMore_mon_trang_mieng);
=======
        btnMoreAnSang = rootView.findViewById(R.id.btn_an_sang);
        btnMoreKhaiVi = rootView.findViewById(R.id.btn_mon_khai_vi);
        btnMoreMonChinh = rootView.findViewById(R.id.btn_mon_chinh);
        btnMoreTrangMieng = rootView.findViewById(R.id.btn_mon_trang_mieng);
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b

        btnMoreAnSang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Intent intent = new Intent(getActivity(), MoreActivity.class);
=======
                Intent intent = new Intent(getActivity(),MoreActivity.class);
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
                startActivity(intent);
            }
        });
        btnMoreKhaiVi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Intent intent = new Intent(getActivity(), MoreActivity.class);
=======
                Intent intent = new Intent(getActivity(),MoreActivity.class);
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
                startActivity(intent);
            }
        });

        btnMoreMonChinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Intent intent = new Intent(getActivity(), MoreActivity.class);
=======
                Intent intent = new Intent(getActivity(),MoreActivity.class);
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
                startActivity(intent);
            }
        });

        btnMoreTrangMieng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
<<<<<<< HEAD
                Intent intent = new Intent(getActivity(), MoreActivity.class);
=======
                Intent intent = new Intent(getActivity(),MoreActivity.class);
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
                startActivity(intent);
            }
        });


        return rootView;
    }
<<<<<<< HEAD

=======
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // recyclerview
        LinearLayoutManager layoutManagerAnSang = new LinearLayoutManager(
<<<<<<< HEAD
                getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerMonKhaiVi = new LinearLayoutManager(
                getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerMonChinh = new LinearLayoutManager(
                getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManagerTrangMieng = new LinearLayoutManager(
                getActivity(), LinearLayoutManager.HORIZONTAL, false);
=======
                getActivity(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManagerMonKhaiVi = new LinearLayoutManager(
                getActivity(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManagerMonChinh = new LinearLayoutManager(
                getActivity(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManagerTrangMieng = new LinearLayoutManager(
                getActivity(),LinearLayoutManager.HORIZONTAL,false);
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b

        mRecycleView_an_sang.setLayoutManager(layoutManagerAnSang);
        mRecycleView_khai_vi.setLayoutManager(layoutManagerMonChinh);
        mRecycleView_mon_chinh.setLayoutManager(layoutManagerMonKhaiVi);
        mRecycleView_trang_mieng.setLayoutManager(layoutManagerTrangMieng);
<<<<<<< HEAD
        createAdapter();

        super.onViewCreated(view, savedInstanceState);
    }
    public void createAdapter() {
        mRecycleView_an_sang.hasFixedSize();
        mRecycleView_mon_chinh.hasFixedSize();
        mRecycleView_trang_mieng.hasFixedSize();
        mRecycleView_khai_vi.hasFixedSize();
        MonSangAdapter monSangAdapter = new MonSangAdapter(getContext(), DataHandle.getHandle(getContext()).getListFoodMonSang());
        mRecycleView_an_sang.setAdapter(monSangAdapter);
        MonKhaiViAdapter monKhaiViAdapter = new MonKhaiViAdapter(getContext(), DataHandle.getHandle(getContext()).getListFoodMonKhaiVi());
        mRecycleView_khai_vi.setAdapter(monKhaiViAdapter);
        MonChinhAdapter monChinhAdapter = new MonChinhAdapter(getContext(), DataHandle.getHandle(getContext()).getListFoodMonChinh());
        mRecycleView_mon_chinh.setAdapter(monChinhAdapter);
        MonTrangMiengAdapter monTrangMiengAdapter = new MonTrangMiengAdapter(getContext(), DataHandle.getHandle(getContext()).getListFoodMonTrangMieng());
        mRecycleView_trang_mieng.setAdapter(monTrangMiengAdapter);
    }
}
=======

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
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b

