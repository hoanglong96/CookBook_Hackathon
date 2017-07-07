package com.example.rufflez.Cookbook.model;

import java.util.ArrayList;

/**
 * Created by HoangLong on 6/27/2017.
 */

public class FoodTypeDataModel {
    private String headerTitle;
<<<<<<< HEAD:app/src/main/java/com/example/rufflez/Cookbook/model/FoodTypeDataModel.java
    private ArrayList<MonSangModel> allItemsInSection;
=======
    private ArrayList<ItemInTypeFoodModel> allItemsInSection;
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b:app/src/main/java/com/example/rufflez/Cookbook/model/FoodTypeDataModel.java


    public FoodTypeDataModel() {

    }
<<<<<<< HEAD:app/src/main/java/com/example/rufflez/Cookbook/model/FoodTypeDataModel.java
    public FoodTypeDataModel(String headerTitle, ArrayList<MonSangModel> allItemsInSection) {
=======
    public FoodTypeDataModel(String headerTitle, ArrayList<ItemInTypeFoodModel> allItemsInSection) {
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b:app/src/main/java/com/example/rufflez/Cookbook/model/FoodTypeDataModel.java
        this.headerTitle = headerTitle;
        this.allItemsInSection = allItemsInSection;
    }



    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

<<<<<<< HEAD:app/src/main/java/com/example/rufflez/Cookbook/model/FoodTypeDataModel.java
    public ArrayList<MonSangModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<MonSangModel> allItemsInSection) {
=======
    public ArrayList<ItemInTypeFoodModel> getAllItemsInSection() {
        return allItemsInSection;
    }

    public void setAllItemsInSection(ArrayList<ItemInTypeFoodModel> allItemsInSection) {
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b:app/src/main/java/com/example/rufflez/Cookbook/model/FoodTypeDataModel.java
        this.allItemsInSection = allItemsInSection;
    }

}
