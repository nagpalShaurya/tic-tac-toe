package com.example.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0349R.layout.activity_main2);
    }

    public void startGame_SinglePlayer(View view) {
        startActivity(new Intent(getApplicationContext(), Game_activity.class));
    }

    public void startGame_online(View view) {
        startActivity(new Intent(getApplicationContext(), OnlineLoginActivity.class));
    }

    public void aboutpanel(View view) {
        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
    }

    public void exitgame(View view) {
        System.exit(0);
    }
}
