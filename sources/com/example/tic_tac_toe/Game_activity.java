package com.example.tic_tac_toe;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AlertDialog.Builder;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Random;

public class Game_activity extends AppCompatActivity {
    ArrayList<Integer> Player1 = new ArrayList<>();
    ArrayList<Integer> Player2 = new ArrayList<>();
    int activePlayer = 1;
    int gameState;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0349R.layout.activity_game_activity);
        this.gameState = 1;
    }

    public void GameBoardClick(View view) {
        ImageView selectedImage = (ImageView) view;
        int selectedBlock = 0;
        switch (selectedImage.getId()) {
            case C0349R.C0351id.iv_11 /*2131165279*/:
                selectedBlock = 1;
                break;
            case C0349R.C0351id.iv_12 /*2131165280*/:
                selectedBlock = 2;
                break;
            case C0349R.C0351id.iv_13 /*2131165281*/:
                selectedBlock = 3;
                break;
            case C0349R.C0351id.iv_21 /*2131165282*/:
                selectedBlock = 4;
                break;
            case C0349R.C0351id.iv_22 /*2131165283*/:
                selectedBlock = 5;
                break;
            case C0349R.C0351id.iv_23 /*2131165284*/:
                selectedBlock = 6;
                break;
            case C0349R.C0351id.iv_31 /*2131165285*/:
                selectedBlock = 7;
                break;
            case C0349R.C0351id.iv_32 /*2131165286*/:
                selectedBlock = 8;
                break;
            case C0349R.C0351id.iv_33 /*2131165287*/:
                selectedBlock = 9;
                break;
        }
        PlayGame(selectedBlock, selectedImage);
    }

    /* access modifiers changed from: 0000 */
    public void PlayGame(int selectedBlock, ImageView selectedImage) {
        if (this.gameState == 1) {
            int i = this.activePlayer;
            if (i == 1) {
                selectedImage.setImageResource(C0349R.C0350drawable.ttt_x);
                this.Player1.add(Integer.valueOf(selectedBlock));
                this.activePlayer = 2;
                AutoPlay();
            } else if (i == 2) {
                selectedImage.setImageResource(C0349R.C0350drawable.ttt_o);
                this.Player2.add(Integer.valueOf(selectedBlock));
                this.activePlayer = 1;
            }
            selectedImage.setEnabled(false);
            CheckWinner();
        }
    }

    /* access modifiers changed from: 0000 */
    public void CheckWinner() {
        int winner = 0;
        ArrayList<Integer> arrayList = this.Player1;
        Integer valueOf = Integer.valueOf(1);
        boolean contains = arrayList.contains(valueOf);
        Integer valueOf2 = Integer.valueOf(3);
        Integer valueOf3 = Integer.valueOf(2);
        if (contains && this.Player1.contains(valueOf3) && this.Player1.contains(valueOf2)) {
            winner = 1;
        }
        if (this.Player1.contains(Integer.valueOf(4)) && this.Player1.contains(Integer.valueOf(5)) && this.Player1.contains(Integer.valueOf(6))) {
            winner = 1;
        }
        if (this.Player1.contains(Integer.valueOf(7)) && this.Player1.contains(Integer.valueOf(8)) && this.Player1.contains(Integer.valueOf(9))) {
            winner = 1;
        }
        if (this.Player1.contains(valueOf) && this.Player1.contains(Integer.valueOf(4)) && this.Player1.contains(Integer.valueOf(7))) {
            winner = 1;
        }
        if (this.Player1.contains(valueOf3) && this.Player1.contains(Integer.valueOf(5)) && this.Player1.contains(Integer.valueOf(8))) {
            winner = 1;
        }
        if (this.Player1.contains(valueOf2) && this.Player1.contains(Integer.valueOf(6)) && this.Player1.contains(Integer.valueOf(9))) {
            winner = 1;
        }
        if (this.Player1.contains(valueOf) && this.Player1.contains(Integer.valueOf(5)) && this.Player1.contains(Integer.valueOf(9))) {
            winner = 1;
        }
        if (this.Player1.contains(valueOf2) && this.Player1.contains(Integer.valueOf(5)) && this.Player1.contains(Integer.valueOf(7))) {
            winner = 1;
        }
        if (this.Player2.contains(valueOf) && this.Player2.contains(valueOf3) && this.Player2.contains(valueOf2)) {
            winner = 2;
        }
        if (this.Player2.contains(Integer.valueOf(4)) && this.Player2.contains(Integer.valueOf(5)) && this.Player2.contains(Integer.valueOf(6))) {
            winner = 2;
        }
        if (this.Player2.contains(Integer.valueOf(7)) && this.Player2.contains(Integer.valueOf(8)) && this.Player2.contains(Integer.valueOf(9))) {
            winner = 2;
        }
        if (this.Player2.contains(valueOf) && this.Player2.contains(Integer.valueOf(4)) && this.Player2.contains(Integer.valueOf(7))) {
            winner = 2;
        }
        if (this.Player2.contains(valueOf3) && this.Player2.contains(Integer.valueOf(5)) && this.Player2.contains(Integer.valueOf(8))) {
            winner = 2;
        }
        if (this.Player2.contains(valueOf2) && this.Player2.contains(Integer.valueOf(6)) && this.Player2.contains(Integer.valueOf(9))) {
            winner = 2;
        }
        if (this.Player2.contains(valueOf) && this.Player2.contains(Integer.valueOf(5)) && this.Player2.contains(Integer.valueOf(9))) {
            winner = 2;
        }
        if (this.Player2.contains(valueOf2) && this.Player2.contains(Integer.valueOf(5)) && this.Player2.contains(Integer.valueOf(7))) {
            winner = 2;
        }
        if (winner != 0 && this.gameState == 1) {
            if (winner == 1) {
                ShowAlert("Congratulations Player-1");
            } else if (winner == 2) {
                ShowAlert("Congratulations Player-2");
            }
            this.gameState = 2;
        }
    }

    /* access modifiers changed from: 0000 */
    public void AutoPlay() {
        ArrayList<Integer> emptyBlocks = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (!this.Player1.contains(Integer.valueOf(i)) && !this.Player2.contains(Integer.valueOf(i))) {
                emptyBlocks.add(Integer.valueOf(i));
            }
        }
        if (emptyBlocks.size() == 0) {
            CheckWinner();
            if (this.gameState == 1) {
                new Builder(this, 16974374);
                ShowAlert("Draw");
            }
            this.gameState = 3;
            return;
        }
        int selectedBock = ((Integer) emptyBlocks.get(new Random().nextInt(emptyBlocks.size()))).intValue();
        ImageView selectedImage = (ImageView) findViewById(C0349R.C0351id.iv_11);
        switch (selectedBock) {
            case 1:
                selectedImage = (ImageView) findViewById(C0349R.C0351id.iv_11);
                break;
            case 2:
                selectedImage = (ImageView) findViewById(C0349R.C0351id.iv_12);
                break;
            case 3:
                selectedImage = (ImageView) findViewById(C0349R.C0351id.iv_13);
                break;
            case 4:
                selectedImage = (ImageView) findViewById(C0349R.C0351id.iv_21);
                break;
            case 5:
                selectedImage = (ImageView) findViewById(C0349R.C0351id.iv_22);
                break;
            case 6:
                selectedImage = (ImageView) findViewById(C0349R.C0351id.iv_23);
                break;
            case 7:
                selectedImage = (ImageView) findViewById(C0349R.C0351id.iv_31);
                break;
            case 8:
                selectedImage = (ImageView) findViewById(C0349R.C0351id.iv_32);
                break;
            case 9:
                selectedImage = (ImageView) findViewById(C0349R.C0351id.iv_33);
                break;
        }
        PlayGame(selectedBock, selectedImage);
    }

    /* access modifiers changed from: 0000 */
    public void ResetGame() {
        this.gameState = 1;
        this.activePlayer = 1;
        this.Player1 = new ArrayList<>();
        this.Player2 = new ArrayList<>();
        ImageView iv = (ImageView) findViewById(C0349R.C0351id.iv_11);
        iv.setImageResource(0);
        iv.setEnabled(true);
        ImageView iv2 = (ImageView) findViewById(C0349R.C0351id.iv_12);
        iv2.setImageResource(0);
        iv2.setEnabled(true);
        ImageView iv3 = (ImageView) findViewById(C0349R.C0351id.iv_13);
        iv3.setImageResource(0);
        iv3.setEnabled(true);
        ImageView iv4 = (ImageView) findViewById(C0349R.C0351id.iv_21);
        iv4.setImageResource(0);
        iv4.setEnabled(true);
        ImageView iv5 = (ImageView) findViewById(C0349R.C0351id.iv_22);
        iv5.setImageResource(0);
        iv5.setEnabled(true);
        ImageView iv6 = (ImageView) findViewById(C0349R.C0351id.iv_23);
        iv6.setImageResource(0);
        iv6.setEnabled(true);
        ImageView iv7 = (ImageView) findViewById(C0349R.C0351id.iv_31);
        iv7.setImageResource(0);
        iv7.setEnabled(true);
        ImageView iv8 = (ImageView) findViewById(C0349R.C0351id.iv_32);
        iv8.setImageResource(0);
        iv8.setEnabled(true);
        ImageView iv9 = (ImageView) findViewById(C0349R.C0351id.iv_33);
        iv9.setImageResource(0);
        iv9.setEnabled(true);
    }

    /* access modifiers changed from: 0000 */
    public void ShowAlert(String Title) {
        String str = "Menu";
        new Builder(this, 16974374).setTitle((CharSequence) Title).setMessage((CharSequence) "Start a new game?").setPositiveButton((CharSequence) "Yes", (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Game_activity.this.ResetGame();
            }
        }).setNegativeButton((CharSequence) str, (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Game_activity.this.startActivity(new Intent(Game_activity.this.getApplicationContext(), Main2Activity.class));
                Game_activity.this.finish();
            }
        }).setIcon(17301543).show();
    }
}
