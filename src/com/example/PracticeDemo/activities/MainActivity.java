package com.example.PracticeDemo.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.PracticeDemo.R;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void btnProgressOnclick(View v) {
        Intent intent = new Intent(MainActivity.this, ProgressBarActivity.class);
        startActivity(intent);
    }

    public void btnSpinnerOnclick(View v) {
        Intent intent = new Intent(MainActivity.this, SpinnerActivity.class);
        startActivity(intent);
    }

    public void btnDatabaseOnclick(View v) {
        Intent intent = new Intent(MainActivity.this, SQLiteActivity.class);
        startActivity(intent);
    }

    public void btnScrollViewOnclick(View v) {
        Intent intent = new Intent(MainActivity.this, ScrollActivity.class);
        startActivity(intent);
    }

}
