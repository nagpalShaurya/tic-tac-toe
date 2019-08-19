package com.example.tic_tac_toe;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p000v4.app.NotificationCompat;
import android.support.p003v7.app.AlertDialog.Builder;
import android.support.p003v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class OnlineLoginActivity extends AppCompatActivity {
    String LoginUID;
    String LoginUserID;
    String UserName;
    ArrayAdapter adpt;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    ArrayList<String> list_loginUsers = new ArrayList<>();
    ArrayList<String> list_requestedUsers = new ArrayList<>();
    ListView lv_loginUsers;
    ListView lv_requstedUsers;
    private FirebaseAuth mAuth;
    private AuthStateListener mAuthListener;
    private FirebaseAnalytics mFirebaseAnalytics;
    DatabaseReference myRef = this.database.getReference();
    ArrayAdapter reqUsersAdpt;
    TextView tvAcceptRequest;
    TextView tvSendRequest;
    TextView tvUserID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0349R.layout.activity_online_login);
        this.tvSendRequest = (TextView) findViewById(C0349R.C0351id.tvSendRequest);
        this.tvAcceptRequest = (TextView) findViewById(C0349R.C0351id.tvAcceptRequest);
        String str = "Please wait...";
        this.tvSendRequest.setText(str);
        this.tvAcceptRequest.setText(str);
        this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        this.mAuth = FirebaseAuth.getInstance();
        this.lv_loginUsers = (ListView) findViewById(C0349R.C0351id.lv_loginUsers);
        this.adpt = new ArrayAdapter(this, 17367043, this.list_loginUsers);
        this.lv_loginUsers.setAdapter(this.adpt);
        this.lv_requstedUsers = (ListView) findViewById(C0349R.C0351id.lv_requestedUsers);
        this.reqUsersAdpt = new ArrayAdapter(this, 17367043, this.list_requestedUsers);
        this.lv_requstedUsers.setAdapter(this.reqUsersAdpt);
        this.tvUserID = (TextView) findViewById(C0349R.C0351id.tvLoginUser);
        this.mAuthListener = new AuthStateListener() {
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                String str = "Auth";
                if (user != null) {
                    OnlineLoginActivity.this.LoginUID = user.getUid();
                    StringBuilder sb = new StringBuilder();
                    sb.append("onAuthStateChanged:signed_in:");
                    sb.append(OnlineLoginActivity.this.LoginUID);
                    Log.d(str, sb.toString());
                    OnlineLoginActivity.this.LoginUserID = user.getEmail();
                    OnlineLoginActivity.this.tvUserID.setText(OnlineLoginActivity.this.LoginUserID);
                    OnlineLoginActivity onlineLoginActivity = OnlineLoginActivity.this;
                    onlineLoginActivity.UserName = onlineLoginActivity.convertEmailToString(onlineLoginActivity.LoginUserID);
                    OnlineLoginActivity onlineLoginActivity2 = OnlineLoginActivity.this;
                    onlineLoginActivity2.UserName = onlineLoginActivity2.UserName.replace(".", "");
                    String str2 = "users";
                    OnlineLoginActivity.this.myRef.child(str2).child(OnlineLoginActivity.this.UserName).child(NotificationCompat.CATEGORY_STATUS).setValue("true");
                    OnlineLoginActivity.this.myRef.child(str2).child(OnlineLoginActivity.this.UserName).child("request").setValue(OnlineLoginActivity.this.LoginUID);
                    OnlineLoginActivity.this.manageConnection();
                    OnlineLoginActivity.this.reqUsersAdpt.clear();
                    OnlineLoginActivity.this.AcceptIncommingRequests();
                    return;
                }
                Log.d(str, "onAuthStateChanged:signed_out");
                OnlineLoginActivity.this.JoinOnlineGame();
            }
        };
        this.myRef.getRoot().child("users").addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                OnlineLoginActivity.this.updateLoginUsers(dataSnapshot);
            }

            public void onCancelled(DatabaseError databaseError) {
            }
        });
        this.lv_loginUsers.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                OnlineLoginActivity.this.confirmRequest(((TextView) view).getText().toString(), "To");
            }
        });
        this.lv_requstedUsers.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                OnlineLoginActivity.this.confirmRequest(((TextView) view).getText().toString(), "From");
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void manageConnection() {
        final DatabaseReference connectionReference = this.database.getReference().child("users");
        this.database.getReference(".info/connected").addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (((Boolean) dataSnapshot.getValue(Boolean.TYPE)).booleanValue()) {
                    DatabaseReference con = connectionReference.child(OnlineLoginActivity.this.UserName).child(NotificationCompat.CATEGORY_STATUS);
                    System.out.println(OnlineLoginActivity.this.UserName);
                    con.setValue("true");
                    con.onDisconnect().setValue("false");
                }
            }

            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    /* access modifiers changed from: 0000 */
    public void confirmRequest(final String OtherPlayer, final String reqType) {
        Builder b = new Builder(this);
        b.setView(getLayoutInflater().inflate(C0349R.layout.connect_player_dialog, null));
        b.setTitle((CharSequence) "Start Game?");
        StringBuilder sb = new StringBuilder();
        sb.append("Connect with ");
        sb.append(OtherPlayer);
        b.setMessage((CharSequence) sb.toString());
        b.setPositiveButton((CharSequence) "Yes", (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                OnlineLoginActivity.this.myRef.child("users").child(OtherPlayer).child("request").push().setValue(OnlineLoginActivity.this.LoginUserID);
                String str = "From";
                String str2 = ":";
                if (reqType.equalsIgnoreCase(str)) {
                    OnlineLoginActivity onlineLoginActivity = OnlineLoginActivity.this;
                    StringBuilder sb = new StringBuilder();
                    sb.append(OtherPlayer);
                    sb.append(str2);
                    sb.append(OnlineLoginActivity.this.UserName);
                    onlineLoginActivity.StartGame(sb.toString(), OtherPlayer, str);
                    return;
                }
                OnlineLoginActivity onlineLoginActivity2 = OnlineLoginActivity.this;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(OnlineLoginActivity.this.UserName);
                sb2.append(str2);
                sb2.append(OtherPlayer);
                onlineLoginActivity2.StartGame(sb2.toString(), OtherPlayer, "To");
            }
        });
        b.setNegativeButton((CharSequence) "Back", (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        b.show();
    }

    /* access modifiers changed from: 0000 */
    public void StartGame(String PlayerGameID, String OtherPlayer, String requestType) {
        this.myRef.child("playing").child(PlayerGameID).removeValue();
        Intent intent = new Intent(getApplicationContext(), OnlineGameActivity.class);
        intent.putExtra("player_session", PlayerGameID);
        intent.putExtra("user_name", this.UserName);
        intent.putExtra("other_player", OtherPlayer);
        intent.putExtra("login_uid", this.LoginUID);
        intent.putExtra("request_type", requestType);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public String convertEmailToString(String Email) {
        return Email.substring(0, Email.indexOf(64)).replace(".", "");
    }

    /* access modifiers changed from: 0000 */
    public void AcceptIncommingRequests() {
        this.myRef.child("users").child(this.UserName).child("request").addValueEventListener(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    HashMap<String, Object> map = (HashMap) dataSnapshot.getValue();
                    if (map != null) {
                        String str = "";
                        for (String key : map.keySet()) {
                            OnlineLoginActivity.this.reqUsersAdpt.add(OnlineLoginActivity.this.convertEmailToString((String) map.get(key)));
                            OnlineLoginActivity.this.reqUsersAdpt.notifyDataSetChanged();
                            OnlineLoginActivity.this.myRef.child("users").child(OnlineLoginActivity.this.UserName).child("request").setValue(OnlineLoginActivity.this.LoginUID);
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

    public void updateLoginUsers(DataSnapshot dataSnapshot) {
        String str = "";
        Set<String> set = new HashSet<>();
        for (DataSnapshot item : dataSnapshot.getChildren()) {
            String name = item.getKey();
            if (item.child(NotificationCompat.CATEGORY_STATUS).getValue().toString().equals("true") && !name.equals(this.UserName)) {
                set.add(name);
            }
        }
        this.adpt.clear();
        this.adpt.addAll(set);
        this.adpt.notifyDataSetChanged();
        this.tvSendRequest.setText("Online Friends");
        this.tvAcceptRequest.setText("Invites");
    }

    public void onStart() {
        super.onStart();
        this.mAuth.addAuthStateListener(this.mAuthListener);
    }

    public void onStop() {
        super.onStop();
        AuthStateListener authStateListener = this.mAuthListener;
        if (authStateListener != null) {
            this.mAuth.removeAuthStateListener(authStateListener);
        }
    }

    public void RegisterUser(String email, String password) {
        this.mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((Activity) this, (OnCompleteListener<TResult>) new OnCompleteListener<AuthResult>() {
            public void onComplete(@NonNull Task<AuthResult> task) {
                StringBuilder sb = new StringBuilder();
                sb.append("createUserWithEmail:onComplete:");
                sb.append(task.isSuccessful());
                Log.d("Auth Complete", sb.toString());
                if (!task.isSuccessful()) {
                    Toast.makeText(OnlineLoginActivity.this.getApplicationContext(), "Auth failed", 0).show();
                }
            }
        });
    }

    public void JoinOnlineGame() {
        Builder b = new Builder(this);
        View dialogView = getLayoutInflater().inflate(C0349R.layout.login_dialog, null);
        b.setView(dialogView);
        final EditText etEmail = (EditText) dialogView.findViewById(C0349R.C0351id.etEmail);
        final EditText etPassword = (EditText) dialogView.findViewById(C0349R.C0351id.etPassword);
        b.setTitle((CharSequence) "Please register");
        b.setMessage((CharSequence) "Enter you email and password for registration");
        b.setPositiveButton((CharSequence) "Register", (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                OnlineLoginActivity.this.RegisterUser(etEmail.getText().toString(), etPassword.getText().toString());
            }
        });
        b.setNegativeButton((CharSequence) "Back", (OnClickListener) new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                OnlineLoginActivity.this.startActivity(new Intent(OnlineLoginActivity.this.getApplicationContext(), Main2Activity.class));
                OnlineLoginActivity.this.finish();
            }
        });
        b.show();
    }
}
