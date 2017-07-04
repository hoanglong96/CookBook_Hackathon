package com.example.rufflez.Cookbook.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rufflez.Cookbook.R;
import com.example.rufflez.Cookbook.adapter.RecyclerViewDataAdapter;
import com.example.rufflez.Cookbook.model.FoodTypeDataModel;
import com.example.rufflez.Cookbook.model.ItemInTypeFoodModel;

import java.util.ArrayList;

/**
 * Created by rufflez on 6/20/15.
 */
public class HomeFragment extends Fragment{
    ArrayList<FoodTypeDataModel> allSampleData = new ArrayList<FoodTypeDataModel>();;
    RecyclerView mRecycleView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        mRecycleView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        // recyclerview
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycleView.setLayoutManager(layoutManager);
        createDummyData();
        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(getActivity(), allSampleData);

        mRecycleView.setAdapter(adapter);
        super.onViewCreated(view, savedInstanceState);
    }

    public void createDummyData() {
        for (int i = 1; i <= 5; i++) {

            FoodTypeDataModel dm = new FoodTypeDataModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<ItemInTypeFoodModel> singleItem = new ArrayList<ItemInTypeFoodModel>();
            for (int j = 0; j <= 5; j++) {
                singleItem.add(new ItemInTypeFoodModel("Item " + j, "URL " + j));
            }
            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
    }
}
