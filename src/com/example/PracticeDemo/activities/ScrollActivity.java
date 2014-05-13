package com.example.PracticeDemo.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.PracticeDemo.R;
import com.example.PracticeDemo.util.HttpUtils;

/**
 * @Description: User: Administrator
 * Date: 14-5-13
 * Time: 16:39
 */
public class ScrollActivity extends Activity {
    private LinearLayout linearLayout;
    private ProgressDialog dialog;

    public static final String HTML_PATH = "http://china.nba.com/news/4/2014-05-13/1104/20834.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview);
        dialog = new ProgressDialog(this);
        dialog.setTitle("提示");
        dialog.setMessage("loading...");
        linearLayout = (LinearLayout) findViewById(R.id.line);

//        for (int i = 0; i < 10; i++) {
//            ImageView imageView = new ImageView(this);
//            Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
//            imageView.setImageDrawable(drawable);
//            linearLayout.addView(imageView);
//        }
        new MyTask().execute(HTML_PATH);
    }

    class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog.show();
        }

        @Override
        protected String doInBackground(String... params) {
            String result = HttpUtils.get(params[0], "utf-8");
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            TextView textView = new TextView(ScrollActivity.this);
            Spanned html = Html.fromHtml(s);
            textView.setText(html);
            linearLayout.addView(textView);
            dialog.dismiss();
        }
    }
}
