package com.example.PracticeDemo.activities;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.example.PracticeDemo.R;

/**
 * @Description: User: Administrator
 * Date: 14-5-12
 * Time: 11:07
 */
public class ProgressBarActivity extends Activity {
    private ProgressBar progressBar;
    private MyTask task;
    private Button btnStart;
    private Button btnEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressbar);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        btnEnd.setClickable(false);

    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume -->");

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (task != null) {
            if (!task.isCancelled()) {
                task.cancel(true);
                task = null;
            }
        }
    }

    public void btnStartOnclick(View v) {
        task = new MyTask();
        task.execute();
        btnEnd.setClickable(true);

    }

    public void btnEndOnclick(View v) {
        task.cancel(true);
        task = null;
        progressBar.setProgress(1);
        btnEnd.setClickable(false);
    }

    class MyTask extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            System.out.println("MyTask -->");
            int i = 1;
            while (i < 100) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
                i++;
            }
            Looper.prepare();
            Toast.makeText(ProgressBarActivity.this, "任务已结束！", 1).show();
            Looper.loop();
            btnEnd.setClickable(false);
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }
    }
}
