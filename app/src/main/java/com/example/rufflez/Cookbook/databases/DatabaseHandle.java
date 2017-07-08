package com.example.rufflez.Cookbook.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.rufflez.Cookbook.model.MonChinhModel;
import com.example.rufflez.Cookbook.model.MonKhaiViModel;
import com.example.rufflez.Cookbook.model.MonSangModel;
import com.example.rufflez.Cookbook.model.MonTrangMiengModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac-vuongvu on 6/27/17.
 */

public class DatabaseHandle {
    private MyDatabase myDataBase;

    public DatabaseHandle(Context context) {
        myDataBase = new MyDatabase(context);
    }

    private static DatabaseHandle handle;

    public static DatabaseHandle getHandle(Context context) {
        if (handle == null) {
            handle = new DatabaseHandle(context);
        }
        return handle;
    }

    private SQLiteDatabase foodDataBase;

    public List<MonSangModel> getListFoodMonSang() {
        foodDataBase = myDataBase.getReadableDatabase();
        List<MonSangModel> foodModelList = new ArrayList<>();
        Cursor cursor = foodDataBase.rawQuery("SELECT * FROM mainfoods\n" +
                "WHERE  loai_mon_an='Món sáng';", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String typeFood = cursor.getString(1);
            String avatarFood = cursor.getString(2);
            String titleFood = cursor.getString(3);
            String ingredientFood = cursor.getString(4);
            String methodFood = cursor.getString(5);
            //Boolean bookmark = cursor.getInt(6) !=0 ;
            MonSangModel foodModel = new MonSangModel( typeFood, avatarFood, titleFood, ingredientFood, methodFood);

            foodModelList.add(foodModel);
            cursor.moveToNext();
        }
        return foodModelList;
    }

    public List<MonKhaiViModel> getListFoodMonKhaiVi() {
        foodDataBase = myDataBase.getReadableDatabase();
        List<MonKhaiViModel> foodModelList = new ArrayList<>();
        Cursor cursor = foodDataBase.rawQuery("SELECT * FROM mainfoods\n" +
                "WHERE  loai_mon_an='Món khai vị';", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String typyFood = cursor.getString(1);
            String avatarFood = cursor.getString(2);
            String titleFood = cursor.getString(3);
            String ingredientFood = cursor.getString(4);
            String methodFood = cursor.getString(5);
            //Boolean bookmark = cursor.getInt(6) !=0 ;

            MonKhaiViModel foodModel = new MonKhaiViModel( typyFood, avatarFood, titleFood, ingredientFood, methodFood);
            foodModelList.add(foodModel);
            cursor.moveToNext();
        }
        return foodModelList;
    }


    public List<MonChinhModel> getListFoodMonChinh() {
        foodDataBase = myDataBase.getReadableDatabase();
        List<MonChinhModel> foodModelList = new ArrayList<>();
        Cursor cursor = foodDataBase.rawQuery("SELECT * FROM mainfoods\n" +
                "WHERE  loai_mon_an='Món chính';", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String typyFood = cursor.getString(1);
            String avatarFood = cursor.getString(2);
            String titleFood = cursor.getString(3);
            String ingredientFood = cursor.getString(4);
            String methodFood = cursor.getString(5);
            //Boolean bookmark = cursor.getInt(6) !=0 ;

            MonChinhModel foodModel = new MonChinhModel( typyFood, avatarFood, titleFood, ingredientFood, methodFood);
            foodModelList.add(foodModel);
            cursor.moveToNext();
        }
        return foodModelList;
    }


    public List<MonTrangMiengModel> getListFoodMonTrangMieng() {
        foodDataBase = myDataBase.getReadableDatabase();
        List<MonTrangMiengModel> foodModelList = new ArrayList<>();
        Cursor cursor = foodDataBase.rawQuery("SELECT * FROM mainfoods\n" +
                "WHERE  loai_mon_an='Món tráng miệng';", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String typyFood = cursor.getString(1);
            String avatarFood = cursor.getString(2);
            String titleFood = cursor.getString(3);
            String ingredientFood = cursor.getString(4);
            String methodFood = cursor.getString(5);
            //Boolean bookmark = cursor.getInt(6) !=0 ;

            MonTrangMiengModel foodModel = new MonTrangMiengModel( typyFood, avatarFood, titleFood, ingredientFood, methodFood);
            foodModelList.add(foodModel);
            cursor.moveToNext();
        }
        return foodModelList;
    }

    public List<FoodModel> getListFood() {
        foodDataBase = myDataBase.getReadableDatabase();
        List<FoodModel> foodModelList = new ArrayList<>();
        Cursor cursor = foodDataBase.rawQuery("SELECT * FROM mainfoods\n" ,
                null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String typyFood = cursor.getString(1);
            String avatarFood = cursor.getString(2);
            String titleFood = cursor.getString(3);
            String ingredientFood = cursor.getString(4);
            String methodFood = cursor.getString(5);
            //Boolean bookmark = cursor.getInt(6) !=0 ;

            FoodModel foodModel = new FoodModel( typyFood, avatarFood, titleFood, ingredientFood, methodFood);
            foodModelList.add(foodModel);
            cursor.moveToNext();
        }
        return foodModelList;
    }

//    public void setBookmark(boolean isBookmark,FoodModel storyModel){
//        foodDataBase = myDataBase.getWritableDatabase();
//        ContentValues contentValues = new ContentValues();
//        if(isBookmark){
//            contentValues.put("bookmark",1);
//        }else{
//            contentValues.put("bookmark",0);
//        }
//        foodDataBase.update("tbl_short_story",contentValues,"id = " + storyModel,null);
//    }

}

