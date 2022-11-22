package com.example.kt1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signupactv extends AppCompatActivity {
    EditText edtemail, edtpass;
    Button btnsignup, btnback;
    FirebaseAuth mauth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactv);
        mauth = FirebaseAuth.getInstance();
        edtemail = (EditText) findViewById(R.id.edtemailsignup);
        edtpass = (EditText) findViewById(R.id.edtpasssu);
        btnsignup = (Button) findViewById(R.id.btndangkysu);
        btnback = (Button) findViewById(R.id.btngoback);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                regis();
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(signupactv.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void regis() {
        String email, pass;
        email = edtemail.getText().toString();
        pass = edtpass.getText().toString();
        mauth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(getApplicationContext(), "Tao tai khoan thanh cong", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Tap tai khoan that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}