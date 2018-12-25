package com.example.valentinpoisson.embeddedsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by valentinpoisson on 14/12/2018.
 */

public class LessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
    }

    public void SubmitCours(View v){
        startActivity(new Intent(LessonActivity.this, HomeActivity.class));
        finish();
    }

}