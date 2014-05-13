package com.example.PracticeDemo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.PracticeDemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: User: Administrator
 * Date: 14-5-12
 * Time: 16:01
 */
public class SpinnerActivity extends Activity {
    private Spinner spinner;
    private Spinner spinner2;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<CharSequence> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner);
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

        //Above
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = spinner.getItemAtPosition(position).toString();
                Toast.makeText(SpinnerActivity.this, "您选中了" + item, 1).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter = new ArrayAdapter<String>(SpinnerActivity.this, android.R.layout.simple_spinner_dropdown_item, getDataSource());
        spinner.setAdapter(adapter);


        //Below
        //加载xml方式
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = spinner2.getItemAtPosition(position).toString();
                Toast.makeText(SpinnerActivity.this, "您选中了" + item, 1).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        adapter2 = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter2);
    }

    private List<String> getDataSource() {
        List<String> list = new ArrayList<String>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        return list;
    }
}
