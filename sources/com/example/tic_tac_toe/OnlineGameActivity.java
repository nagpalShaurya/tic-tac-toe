package com.example.tic_tac_toe;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.p003v7.app.AlertDialog.Builder;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;

public class OnlineGameActivity extends AppCompatActivity {
    ArrayList<Integer> Player1 = new ArrayList<>();
    ArrayList<Integer> Player2 = new ArrayList<>();
    int activePlayer = 1;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    int gameState = 0;
    String loginUID;
    String myGameSign = "X";
    DatabaseReference myRef = this.database.getReference();
    String otherPlayer;
    String playerSession;
    String requestType;
    TextView tvPlayer1;
    TextView tvPlayer2;
    String userName;

    public OnlineGameActivity() {
        String str = "";
        this.playerSession = str;
        this.userName = str;
        this.otherPlayer = str;
        this.loginUID = str;
        this.requestType = str;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0349R.layout.activity_online_game);
        this.userName = getIntent().getExtras().get("user_name").toString();
        this.loginUID = getIntent().getExtras().get("login_uid").toString();
        this.otherPlayer = getIntent().getExtras().get("other_player").toString();
        this.requestType = getIntent().getExtras().get("request_type").toString();
        this.playerSession = getIntent().getExtras().get("player_session").toString();
        this.tvPlayer1 = (TextView) findViewById(C0349R.C0351id.tvPlayer1);
        ImageView ivyou = (ImageView) findViewById(C0349R.C0351id.f39x);
        ImageView ivthey = (ImageView) findViewById(C0349R.C0351id.f35o);
        this.gameState = 1;
        String str = "turn";
        String str2 = "playing";
        if (this.requestType.equals("From")) {
            this.myGameSign = "0";
            this.tvPlayer1.setText("Your turn");
            ivyou.setImageResource(C0349R.C0350drawable.ttt_o);
            ivthey.setImageResource(C0349R.C0350drawable.ttt_x);
            this.myRef.child(str2).child(this.playerSession).child(str).setValue(this.userName);
        } else {
            this.myGameSign = "X";
            ivyou.setImageResource(C0349R.C0350drawable.ttt_x);
            ivthey.setImageResource(C0349R.C0350drawable.ttt_o);
            TextView textView = this.tvPlayer1;
            StringBuilder sb = new StringBuilder();
            sb.append(this.otherPlayer);
            sb.append("'s turn");
            textView.setText(sb.toString());
            this.myRef.child(str2).child(this.playerSession).child(str).setValue(this.otherPlayer);
        }
        this.myRef.child(str2).child(this.playerSession).child(str).addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    String value = (String) dataSnapshot.getValue();
                    if (value.equals(OnlineGameActivity.this.userName)) {
                        OnlineGameActivity.this.tvPlayer1.setText("Your turn");
                        OnlineGameActivity.this.setEnableClick(true);
                        OnlineGameActivity.this.activePlayer = 1;
                    } else if (value.equals(OnlineGameActivity.this.otherPlayer)) {
                        TextView textView = OnlineGameActivity.this.tvPlayer1;
                        StringBuilder sb = new StringBuilder();
                        sb.append(OnlineGameActivity.this.otherPlayer);
                        sb.append("'s turn");
                        textView.setText(sb.toString());
                        OnlineGameActivity.this.setEnableClick(false);
                        OnlineGameActivity.this.activePlayer = 2;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
        this.myRef.child(str2).child(this.playerSession).child("game").addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    OnlineGameActivity.this.Player1.clear();
                    OnlineGameActivity.this.Player2.clear();
                    OnlineGameActivity.this.activePlayer = 2;
                    HashMap<String, Object> map = (HashMap) dataSnapshot.getValue();
                    if (map != null) {
                        String str = "";
                        String str2 = OnlineGameActivity.this.userName;
                        for (String key : map.keySet()) {
                            String value = (String) map.get(key);
                            if (value.equals(OnlineGameActivity.this.userName)) {
                                OnlineGameActivity.this.activePlayer = 2;
                            } else {
                                OnlineGameActivity.this.activePlayer = 1;
                            }
                            String firstPlayer = value;
                            OnlineGameActivity.this.OtherPlayer(Integer.parseInt(key.split(":")[1]));
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onCancelled(DatabaseError error) {
            }
        });
    }

    public void GameBoardClick(View view) {
        ImageView selectedImage = (ImageView) view;
        if (this.playerSession.length() <= 0) {
            startActivity(new Intent(getApplicationContext(), OnlineLoginActivity.class));
            finish();
            return;
        }
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
        String str = "playing";
        DatabaseReference child = this.myRef.child(str).child(this.playerSession).child("game");
        StringBuilder sb = new StringBuilder();
        sb.append("block:");
        sb.append(selectedBlock);
        child.child(sb.toString()).setValue(this.userName);
        this.myRef.child(str).child(this.playerSession).child("turn").setValue(this.otherPlayer);
        setEnableClick(false);
        this.activePlayer = 2;
        PlayGame(selectedBlock, selectedImage);
    }

    /* access modifiers changed from: 0000 */
    public void PlayGame(int selectedBlock, ImageView selectedImage) {
        if (this.gameState == 1) {
            int i = this.activePlayer;
            if (i == 1) {
                selectedImage.setImageResource(C0349R.C0350drawable.ttt_x);
                this.Player1.add(Integer.valueOf(selectedBlock));
            } else if (i == 2) {
                selectedImage.setImageResource(C0349R.C0350drawable.ttt_o);
                this.Player2.add(Integer.valueOf(selectedBlock));
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
        Integer valueOf2 = Integer.valueOf(2);
        Integer valueOf3 = Integer.valueOf(3);
        if (contains && this.Player1.contains(valueOf2) && this.Player1.contains(valueOf3)) {
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
        if (this.Player1.contains(valueOf2) && this.Player1.contains(Integer.valueOf(5)) && this.Player1.contains(Integer.valueOf(8))) {
            winner = 1;
        }
        if (this.Player1.contains(valueOf3) && this.Player1.contains(Integer.valueOf(6)) && this.Player1.contains(Integer.valueOf(9))) {
            winner = 1;
        }
        if (this.Player1.contains(valueOf) && this.Player1.contains(Integer.valueOf(5)) && this.Player1.contains(Integer.valueOf(9))) {
            winner = 1;
        }
        if (this.Player1.contains(valueOf3) && this.Player1.contains(Integer.valueOf(5)) && this.Player1.contains(Integer.valueOf(7))) {
            winner = 1;
        }
        if (this.Player2.contains(valueOf) && this.Player2.contains(valueOf2) && this.Player2.contains(valueOf3)) {
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
        if (this.Player2.contains(valueOf2) && this.Player2.contains(Integer.valueOf(5)) && this.Player2.contains(Integer.valueOf(8))) {
            winner = 2;
        }
        if (this.Player2.contains(valueOf3) && this.Player2.contains(Integer.valueOf(6)) && this.Player2.contains(Integer.valueOf(9))) {
            winner = 2;
        }
        if (this.Player2.contains(valueOf) && this.Player2.contains(Integer.valueOf(5)) && this.Player2.contains(Integer.valueOf(9))) {
            winner = 2;
        }
        if (this.Player2.contains(valueOf3) && this.Player2.contains(Integer.valueOf(5)) && this.Player2.contains(Integer.valueOf(7))) {
            winner = 2;
        }
        if (winner != 0 && this.gameState == 1) {
            if (winner == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.otherPlayer);
                sb.append(" is winner");
                ShowAlert(sb.toString());
            } else if (winner == 2) {
                ShowAlert("You won the game");
            }
            this.gameState = 2;
        }
        ArrayList<Integer> emptyBlocks = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (!this.Player1.contains(Integer.valueOf(i)) && !this.Player2.contains(Integer.valueOf(i))) {
                emptyBlocks.add(Integer.valueOf(i));
            }
        }
        if (emptyBlocks.size() == 0) {
            if (this.gameState == 1) {
                new Builder(this, 16974374);
                ShowAlert("Draw");
            }
            this.gameState = 3;
        }
    }

    /* access modifiers changed from: 0000 */
    public void OtherPlayer(int selectedBlock) {
        ImageView selectedImage = (ImageView) findViewById(C0349R.C0351id.iv_11);
        switch (selectedBlock) {
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
        PlayGame(selectedBlock, selectedImage);
    }

    /* access modifiers changed from: 0000 */
    public void ResetGame() {
        this.gameState = 1;
        this.activePlayer = 1;
        this.Player1.clear();
        this.Player2.clear();
        this.myRef.child("playing").child(this.playerSession).removeValue();
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
                OnlineGameActivity.this.ResetGame();
            }
        }).setNegativeButton((CharSequence) str, (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                OnlineGameActivity.this.startActivity(new Intent(OnlineGameActivity.this.getApplicationContext(), Main2Activity.class));
                OnlineGameActivity.this.finish();
            }
        }).setIcon(17301659).show();
    }

    /* access modifiers changed from: 0000 */
    public void setEnableClick(boolean trueORfalse) {
        ((ImageView) findViewById(C0349R.C0351id.iv_11)).setClickable(trueORfalse);
        ((ImageView) findViewById(C0349R.C0351id.iv_12)).setClickable(trueORfalse);
        ((ImageView) findViewById(C0349R.C0351id.iv_13)).setClickable(trueORfalse);
        ((ImageView) findViewById(C0349R.C0351id.iv_21)).setClickable(trueORfalse);
        ((ImageView) findViewById(C0349R.C0351id.iv_22)).setClickable(trueORfalse);
        ((ImageView) findViewById(C0349R.C0351id.iv_23)).setClickable(trueORfalse);
        ((ImageView) findViewById(C0349R.C0351id.iv_31)).setClickable(trueORfalse);
        ((ImageView) findViewById(C0349R.C0351id.iv_32)).setClickable(trueORfalse);
        ((ImageView) findViewById(C0349R.C0351id.iv_33)).setClickable(trueORfalse);
    }
}
