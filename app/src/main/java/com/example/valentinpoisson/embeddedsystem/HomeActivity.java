package com.example.valentinpoisson.embeddedsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        title = (TextView)findViewById(R.id.textView3);
        Bundle id = getIntent().getExtras();
        title.setText("Welcome " + id.getString("id"));
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
