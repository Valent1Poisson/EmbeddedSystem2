package com.example.valentinpoisson.embeddedsystem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by valentinpoisson on 14/12/2018.
 */

public class CardActivity extends AppCompatActivity {

    TextView Name1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Name1 = (TextView) findViewById(R.id.NameField);

        Bundle position = getIntent().getExtras();
        String Name = position.getString("id");
        Name1.setText(Name);
    }

    public void StartCallActivity(View v){
        Intent intent = new Intent(CardActivity.this, CallActivity.class);
        String num = "";
        String id = "id";
        intent.putExtra(id,num);
        startActivity(intent);
    }

}