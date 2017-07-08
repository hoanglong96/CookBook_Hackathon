package com.example.rufflez.Cookbook.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.rufflez.Cookbook.DetailFoodActivity;
import com.example.rufflez.Cookbook.adapter.FavFoodAdapter;
import com.example.rufflez.myapplication.R;

/**
 * Created by rufflez on 6/20/15.
 */
public class FavoritesFragment extends Fragment {

    GridView grid;
    String[] web = {
            "Cháo gà",
            "Phở bò",
            "Xôi xéo",
            "Gà tần",
            "Cơm rang",
            "Bánh mỳ",
            "Hoành thánh",
            "Mỳ tôm",
            "Bánh bao",
            "Bánh gạo",
            "Kimbap",
            "Bánh mỳ cuộn",
            "Bún măng",
            "Bánh bông lanh",
            "Sữa tươi"

    };
    int[] imageId = {
            R.drawable.ga,
            R.drawable.garan,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,
            R.drawable.ic_launcher,

    };
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favourites, container, false);

        FavFoodAdapter adapter = new FavFoodAdapter(getActivity(), web, imageId);
        grid = (GridView) rootView.findViewById(R.id.grid_fav);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " + web[+position], Toast.LENGTH_SHORT).show();
                Intent detailFood = new Intent(getActivity(), DetailFoodActivity.class);
                startActivity(detailFood);
            }
        });
        return rootView;
    }
}
