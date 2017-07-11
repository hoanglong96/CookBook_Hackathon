package com.example.rufflez.Cookbook.utils;

import com.example.rufflez.Cookbook.databases.FoodModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HoangLong on 7/11/2017.
 */

public class UtilsNguyenLieu {
    public static List<FoodModel> loclist (List<FoodModel> foodModelList, String text){
        List<FoodModel> foodModels = new ArrayList<>();
        for (FoodModel foodModel: foodModelList) {
            if (foodModel.getNguyenLieuDaChon().equals(text)) {
                foodModels.add(foodModel);
            }
        }

        return foodModels;
    }
}
