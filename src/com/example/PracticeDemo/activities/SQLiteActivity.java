package com.example.PracticeDemo.activities;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.PracticeDemo.R;
import com.example.PracticeDemo.util.DatabaseHelper;

/**
 * @Description: User: Administrator
 * Date: 14-5-13
 * Time: 11:36
 */
public class SQLiteActivity extends Activity {
    private static final String DATABASE_NAME = "test_db";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite);

        Button createDatabaseButton = (Button) findViewById(R.id.createDatabase);
        Button updateDatabaseButton = (Button) findViewById(R.id.updateDatabase);
        Button insertButton = (Button) findViewById(R.id.insert);
        Button updateButton = (Button) findViewById(R.id.update);
        Button selectButton = (Button) findViewById(R.id.select);
        Button deleteButton = (Button) findViewById(R.id.delete);

        createDatabaseButton.setOnClickListener(new CreateDatabaseListener());
        updateDatabaseButton.setOnClickListener(new UpdateDatabaseListener());
        insertButton.setOnClickListener(new InsertOnclickListener());
        updateButton.setOnClickListener(new updateOnclickListener());
        selectButton.setOnClickListener(new SelectOnclickListener());
        deleteButton.setOnClickListener(new DeleteOnclickListener());
    }

    class CreateDatabaseListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // 创建了一个DatabaseHelper对象，只执行这句话是不会创建或打开连接的
            DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this, DATABASE_NAME);
            // 只有调用了DatabaseHelper的getWritableDatabase()方法或者getReadableDatabase()方法之后，才会创建或打开一个连接
            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        }
    }

    class UpdateDatabaseListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this, DATABASE_NAME, 2);
            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
        }
    }

    class InsertOnclickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ContentValues values = new ContentValues();
            values.put("id", "1");
            values.put("name", "qs");
            DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this, DATABASE_NAME, 2);
            SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
            sqLiteDatabase.insert("user", null, values);
        }
    }

    class updateOnclickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            ContentValues values = new ContentValues();
            values.put("name", "zhangsan");
            DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this, DATABASE_NAME, 2);
            SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
            sqLiteDatabase.update("user", values, "id=?", new String[]{"1"});
//            sqLiteDatabase.
            System.out.println("-----------update------------");
        }
    }

    class SelectOnclickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            String id = null;
            String name = null;
            DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this, DATABASE_NAME, 2);
            SQLiteDatabase sqLiteDatabase = dbHelper.getReadableDatabase();
            Cursor cursor = sqLiteDatabase.query("user", new String[]{"id", "name"}, "id=?", new String[]{"1"}, null, null, null);
            while (cursor.moveToNext()) {
                id = cursor.getString(cursor.getColumnIndex("id"));
                name = cursor.getString(cursor.getColumnIndex("name"));
                System.out.println("id = " + id);
                System.out.println("name = " + name);
            }
        }
    }

    class DeleteOnclickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            DatabaseHelper dbHelper = new DatabaseHelper(SQLiteActivity.this, DATABASE_NAME, 2);
            SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();
            sqLiteDatabase.delete("user", "id=?", new String[]{"1"});
        }
    }
}
