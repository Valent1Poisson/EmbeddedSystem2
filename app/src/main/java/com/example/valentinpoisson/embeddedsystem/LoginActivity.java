package com.example.valentinpoisson.embeddedsystem;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    TextView tx1;
    Button b1;
    EditText username,password;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b1 = (Button)findViewById(R.id.button);
        username = (EditText)findViewById(R.id.EditText);
        password = (EditText)findViewById(R.id.EditText2);
        /*
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }else{
                    /*
                    tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText("Attempts left :" + Integer.toString(counter));
                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                    *//*
                }
            }
        });
        */

    }

    public void LoginFct (View v){

        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
            startActivity(new Intent(LoginActivity.this, HomeActivity.class));
        }else{
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            //counter--;
            //tx1.setText("Attempts left :" + Integer.toString(counter));
            /*if (counter == 0) {
                b1.setEnabled(false);
            }*/
        }

    }

}
