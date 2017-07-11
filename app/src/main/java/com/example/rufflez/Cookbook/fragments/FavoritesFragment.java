package com.example.rufflez.Cookbook.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.rufflez.myapplication.R;

/**
 * Created by rufflez on 6/20/15.
 */
public class FavoritesFragment extends Fragment {

    GridView grid;
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favourites, container, false);


//        FavFoodAdapter favFoodAdapter = new FavFoodAdapter(getBaseContext(), Utils.loclist(DatabaseHandle.getInstance(getBaseContext()).getListFood(), "Món sáng"));
//        adapter = gridAdapter1;
//        grid.setAdapter(gridAdapter1);
//
//        FavFoodAdapter adapter = new FavFoodAdapter(getActivity(), web, imageId);
//        grid = (GridView) rootView.findViewById(R.id.grid_fav);
//        grid.setAdapter(adapter);
//        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                Toast.makeText(getActivity(), "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();
//                Intent detailFood = new Intent(getActivity(), DetailFoodActivity.class);
//                startActivity(detailFood);
//            }
//        });
       return rootView;
    }
}
