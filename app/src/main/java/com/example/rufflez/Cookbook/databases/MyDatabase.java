package com.example.rufflez.Cookbook.databases;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by HoangLong on 6/17/2017.
 */

public class MyDatabase extends SQLiteAssetHelper {
<<<<<<< HEAD
    private static final String DATABASE_NAME = "acook_database.db";
=======
    private static final String DATABASE_NAME = "short_story.db";
>>>>>>> b531bf41306e305fbb4f182bedbbad6fb65e772b
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}