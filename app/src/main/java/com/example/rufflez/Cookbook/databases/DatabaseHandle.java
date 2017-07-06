package com.example.rufflez.Cookbook.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHandle {

    //1: Create instance MyDatabase
    private MyDatabase myDatabase;

    public DatabaseHandle(Context context) {
        myDatabase = new MyDatabase(context);
    }

    //2: Create instance DatabaseHandle
    private static DatabaseHandle instance;

    public static DatabaseHandle getInstance(Context context) {
        if (instance == null) {
            instance = new DatabaseHandle(context);
        }
        return instance;
    }

    //3: Create instance SQLiteDatabase
    private SQLiteDatabase storyDatabase;

    //4: get List Story
    public List<StoryModel> getListStory() {
        storyDatabase = myDatabase.getReadableDatabase();
        List<StoryModel> storyModelList = new ArrayList<>();
        Cursor cursor = storyDatabase.rawQuery("select * from tbl_short_story", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String image = cursor.getString(1);
            String title = cursor.getString(2);
            String description = cursor.getString(3);
            String content = cursor.getString(4);
            String author = cursor.getString(5);
            Boolean bookmark = cursor.getInt(6) != 0;

            StoryModel storyModel = new StoryModel(id, image, title, description, content, author, bookmark);
            storyModelList.add(storyModel);
            cursor.moveToNext();
        }
        return storyModelList;
    }

    public void setBookmark(boolean isBookmark, StoryModel storyModel) {
        storyDatabase = myDatabase.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        if (isBookmark) {
            contentValues.put("bookmark", 1);
        } else {
            contentValues.put("bookmark", 0);
        }
        storyDatabase.update("tbl_short_story", contentValues, "id = " + storyModel.getId(), null);
    }
}
