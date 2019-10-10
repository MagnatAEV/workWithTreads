package albul.matirealdesign.android.ru.workwithtreads.acynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.security.KeyStore;
import java.util.concurrent.TimeUnit;

import albul.matirealdesign.android.ru.workwithtreads.R;

public class AsyncTaskActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnTest;
    TestAsyncTask testAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acync_task);
        btnTest = findViewById(R.id.btn_test);
        btnTest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_test:
                testAsyncTask = new TestAsyncTask();
                testAsyncTask.execute();
                Log.d(":", "onClick: success end");
                break;
            default:
                break;
        }
    }

    private static class TestAsyncTask extends AsyncTask<Void, Void, Void> {

        private String TAG = "TestAsyncTask";

        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i < 5; i++) {
                Log.d(TAG, "Tread name:" + Thread.currentThread().getName() + " " + i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(TAG, "Tread name:" + Thread.currentThread().getName() + " end;");
        }
    }



}
