package com.example.PracticeDemo.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @Description: User: QS
 * Date: 14-4-10
 * Time: 14:52
 */

/**
 * SQLiteOpenHelper是一个辅助类，用来管理数据库的创建和版本，它提供两个方面的功能
 * 第一，getReadableDatabase()、getWritableDatabase()可以获得SQLiteDatabase对象，通过该对象可以对数据库进行操作
 * 第二，提供了onCreate()、onUpgrade()两个回调函数，允许我们再创建和升级数据库时，进行自己的操作
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;

    /**
     * @param context 上下文对象
     * @param name    数据库名称
     * @param factory
     * @param version 当前数据库的版本，值必须是整数并且是递增的状态
     */
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHelper(Context context, String name, int version) {
        this(context, name, null, version);
    }

    public DatabaseHelper(Context context, String name) {
        this(context, name, VERSION);
    }

    //该函数是在第一次创建的时候执行，实际上是第一次得到SQLiteDatabase对象的时候才会调用这个方法
    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("create a database.");
        String sql = "create table user(id int,name varchar(20))";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("update the database");
    }
}
