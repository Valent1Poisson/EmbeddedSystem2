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

    public void StartHomeActivity(View v){
        startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
    }
}
