package com.example.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p003v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuth.AuthStateListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class onlineRegister extends AppCompatActivity {
    String LoginUID;
    String LoginUserID;
    String UserName;
    Button btnRegister;
    EditText email;
    final FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private AuthStateListener mAuthListener;
    EditText password;
    final FirebaseUser user = this.mAuth.getCurrentUser();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0349R.layout.activity_online_register);
        this.mAuthListener = new AuthStateListener() {
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (onlineRegister.this.user != null) {
                    onlineRegister onlineregister = onlineRegister.this;
                    onlineregister.startActivity(new Intent(onlineregister, OnlineLoginActivity.class));
                }
            }
        };
        this.email = (EditText) findViewById(C0349R.C0351id.et_email);
        this.password = (EditText) findViewById(C0349R.C0351id.et_pass);
        this.btnRegister = (Button) findViewById(C0349R.C0351id.btn_register);
        this.btnRegister.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                onlineRegister.this.mAuth.createUserWithEmailAndPassword(onlineRegister.this.email.getText().toString(), onlineRegister.this.password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(onlineRegister.this, "Authenticated!!!!", 0).show();
                    }
                });
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
                if (onlineRegister.this.user != null) {
                    onlineRegister onlineregister = onlineRegister.this;
                    onlineregister.LoginUserID = onlineregister.user.getEmail();
                }
                onlineRegister onlineregister2 = onlineRegister.this;
                onlineregister2.UserName = onlineregister2.LoginUserID;
                Toast.makeText(onlineRegister.this, "Added to database", 0).show();
            }
        });
    }

    private String convertEmailToString(String Email) {
        return Email.substring(0, Email.indexOf(64)).replace(".", "");
    }
}
