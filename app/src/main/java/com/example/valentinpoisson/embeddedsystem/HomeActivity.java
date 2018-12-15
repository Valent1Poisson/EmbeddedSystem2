package com.example.valentinpoisson.embeddedsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void TrainingActivity(View v){
        startActivity(new Intent(HomeActivity.this, TrainingActivity.class));
    }

    public void TrainerActivity(View v){
        startActivity(new Intent(HomeActivity.this, TrainerActivity.class));
    }

    public void CalendarActivity(View v){
        startActivity(new Intent(HomeActivity.this, CalendarActivity.class));
    }

    public void LogOutActivity(View v){
        startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        finish();
    }
}
