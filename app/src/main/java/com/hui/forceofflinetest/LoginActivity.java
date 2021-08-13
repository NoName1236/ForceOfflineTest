package com.hui.forceofflinetest;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private EditText accountEd,passwordEd;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        accountEd=findViewById(R.id.account);
        passwordEd=findViewById(R.id.password);
        login=findViewById(R.id.login);
        login.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login) {
            String account = accountEd.getText().toString();
            String password = passwordEd.getText().toString();
            if (account.equals("admin") && password.equals("123456")) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "account or passpord is invalid", Toast.LENGTH_SHORT).show();
            }
        }
    }
}