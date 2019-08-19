package com.example.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;

public class AboutActivity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0349R.layout.activity_about);
    }

    public void goBack(View view) {
        startActivity(new Intent(this, Main2Activity.class));
        finish();
    }
}
