package com.example.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0349R.layout.activity_main);
        new Thread() {
            public void run() {
                MainActivity mainActivity;
                Intent intent;
                try {
                    sleep(1700);
                    mainActivity = MainActivity.this;
                    intent = new Intent(mainActivity, Main2Activity.class);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    mainActivity = MainActivity.this;
                    intent = new Intent(mainActivity, Main2Activity.class);
                } catch (Throwable th) {
                    MainActivity mainActivity2 = MainActivity.this;
                    mainActivity2.startActivity(new Intent(mainActivity2, Main2Activity.class));
                    MainActivity.this.finish();
                    throw th;
                }
                mainActivity.startActivity(intent);
                MainActivity.this.finish();
            }
        }.start();
    }
}
