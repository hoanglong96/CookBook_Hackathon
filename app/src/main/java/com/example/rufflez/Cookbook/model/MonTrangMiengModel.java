package com.example.rufflez.Cookbook.model;

import java.io.Serializable;

/**
 * Created by mac-vuongvu on 7/7/17.
 */

public class MonTrangMiengModel implements Serializable{
    //    private int id;
    private String typyFood;
    private String avatarFood;
    private String titleFood;
    private String ingredientFood;
    private String methodFood;

    public MonTrangMiengModel(String typyFood, String avatarFood, String titleFood, String ingredientFood, String methodFood) {
//        this.id = id;
        this.typyFood = typyFood;
        this.avatarFood = avatarFood;
        this.titleFood = titleFood;
        this.ingredientFood = ingredientFood;
        this.methodFood = methodFood;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getTypyFood() {
        return typyFood;
    }

    public void setTypyFood(String typyFood) {
        this.typyFood = typyFood;
    }

    public String getAvatarFood() {
        return avatarFood;
    }

    public void setAvatarFood(String avatarFood) {
        this.avatarFood = avatarFood;
    }

    public String getTitleFood() {
        return titleFood;
    }

    public void setTitleFood(String titleFood) {
        this.titleFood = titleFood;
    }

    public String getIngredientFood() {
        return ingredientFood;
    }

    public void setIngredientFood(String ingredientFood) {
        this.ingredientFood = ingredientFood;
    }

    public String getMethodFood() {
        return methodFood;
    }

    public void setMethodFood(String methodFood) {
        this.methodFood = methodFood;
    }

    @Override
    public String toString() {
        return "SingleItemModel{" +
//                "id=" + id +
                ", typyFood='" + typyFood + '\'' +
                ", avatarFood='" + avatarFood + '\'' +
                ", titleFood='" + titleFood + '\'' +
                ", ingredientFood='" + ingredientFood + '\'' +
                ", methodFood='" + methodFood + '\'' +
                '}';
    }

}
