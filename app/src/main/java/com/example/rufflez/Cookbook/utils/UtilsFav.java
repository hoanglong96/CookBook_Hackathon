package com.example.rufflez.Cookbook.utils;

import android.util.Log;

import com.example.rufflez.Cookbook.databases.FoodModel;

import java.util.ArrayList;
import java.util.List;

import static github.chenupt.multiplemodel.BaseModelManager.TAG;

/**
 * Created by HoangLong on 7/11/2017.
 */

public class UtilsFav {
    public static List<FoodModel> favList (List<FoodModel> foodModelList, String foodFilter, String foodDisplay){
        List<FoodModel> foodModels = new ArrayList<>();
        for (FoodModel foodModel: foodModelList) {
            if (foodModel.isBookmark()) {
                    foodModels.add(foodModel);
                Log.d(TAG, "favList: " + foodModels.size());
            }
        }

        return foodModels;
    }
}
