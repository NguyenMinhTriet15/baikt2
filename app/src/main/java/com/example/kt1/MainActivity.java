package com.example.kt1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText pass;
    Button btnlogin, btnsignup;
    FirebaseAuth mauth;
    CheckBox cbrmb;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mauth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.edtemail);
        pass = (EditText) findViewById(R.id.edtpass);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnsignup = (Button) findViewById(R.id.btngosu);
        cbrmb = (CheckBox) findViewById(R.id.cb);
        sharedPreferences = getSharedPreferences("datalogin", MODE_PRIVATE);
        email.setText(sharedPreferences.getString("email",""));
        pass.setText(sharedPreferences.getString("password",""));
        cbrmb.setChecked(sharedPreferences.getBoolean("Checked", false));

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signup();
            }
        });
    }

    private void signup() {
        Intent it = new Intent(MainActivity.this,signupactv.class);
        startActivity(it);
    }

    private void login() {
        String emailed, passed;
        emailed = email.getText().toString();
        passed = pass.getText().toString();
        if(TextUtils.isEmpty(emailed)){
            Toast.makeText(this, "Nhap Email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(passed)){
            Toast.makeText(this, "Nhap Password",Toast.LENGTH_SHORT).show();
            return;
        }
        mauth.signInWithEmailAndPassword(emailed,passed).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Intent intent = new Intent(MainActivity.this, Homepage.class);
                    startActivity(intent);
                    if(cbrmb.isChecked()){
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("email", emailed);
                        editor.putString("password", passed);
                        editor.putBoolean("checked", true);
                        editor.commit();
                    }
                }
                else{
                  Toast.makeText(getApplicationContext(), "Sai tai khoan hoac mat khau", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}