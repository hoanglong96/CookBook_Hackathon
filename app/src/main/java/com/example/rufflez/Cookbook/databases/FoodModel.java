package com.example.rufflez.Cookbook.databases;

import java.io.Serializable;

/**
 * Created by HoangLong on 6/17/2017.
 */

public class FoodModel implements Serializable {
    private String typeFood;
    private String avatarFood;
    private String titleFood;
    private String ingredientFood;
    private String methodFood;

    public FoodModel(String typeFood, String avatarFood, String titleFood, String ingredientFood, String methodFood) {
        this.typeFood = typeFood;
        this.avatarFood = avatarFood;
        this.titleFood = titleFood;
        this.ingredientFood = ingredientFood;
        this.methodFood = methodFood;
    }

    public String getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(String typeFood) {
        this.typeFood = typeFood;
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
        return "FoodModel{" +
                "typeFood='" + typeFood + '\'' +
                ", avatarFood='" + avatarFood + '\'' +
                ", titleFood='" + titleFood + '\'' +
                ", ingredientFood='" + ingredientFood + '\'' +
                ", methodFood='" + methodFood + '\'' +
                '}';
    }
}
