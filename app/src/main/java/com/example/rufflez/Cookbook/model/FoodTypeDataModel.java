package com.example.rufflez.Cookbook.model;

import java.util.ArrayList;

/**
 * Created by HoangLong on 6/27/2017.
 */

public class FoodTypeDataModel {
    private String headerTitle;
    private ArrayList<MonSangModel> allItemsInSection;


    public FoodTypeDataModel() {

    }
    public FoodTypeDataModel(String headerTitle, ArrayList<MonSangModel> allItemsInSection) {
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public ArrayList<MonSangModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<MonSangModel> allItemsInSection) {
        this.allItemsInSection = allItemsInSection;
    }

}
