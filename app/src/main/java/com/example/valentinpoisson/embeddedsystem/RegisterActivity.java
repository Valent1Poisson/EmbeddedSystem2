package com.example.valentinpoisson.embeddedsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void StartLogActivity(View v){
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
    }

    public void StartMainActivity(View v){
        startActivity(new Intent(RegisterActivity.this, MainActivity.class));
    }
}
