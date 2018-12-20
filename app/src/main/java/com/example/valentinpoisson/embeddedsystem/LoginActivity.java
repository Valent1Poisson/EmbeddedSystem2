package com.example.valentinpoisson.embeddedsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.valentinpoisson.embeddedsystem.BDD.Account;
import com.example.valentinpoisson.embeddedsystem.BDD.AccountBDD;


import com.example.valentinpoisson.embeddedsystem.BDD.AccountBDD;
import com.example.valentinpoisson.embeddedsystem.dummy.Navigation;

public class LoginActivity extends AppCompatActivity {

    TextView tx1;
    Button b1;
    EditText username,password;
    int counter = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //FacebookSdk.sdkInitialize(getApplicationContext());
        //AppEventsLogger.activateApp(this);

        setContentView(R.layout.activity_login);

        b1 = (Button)findViewById(R.id.button);
        username = (EditText)findViewById(R.id.EditText);
        password = (EditText)findViewById(R.id.EditText2);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

    }

    public void LoginFct (View v){

        //create instance class BDD
        AccountBDD accountBDD = new AccountBDD(this);
        accountBDD.open();
        Account account = accountBDD.getAccountWithMail(username.getText().toString());

        if(account==null){
            Toast.makeText(this,"Incorrect Mail",Toast.LENGTH_LONG).show();
        } else {
            //Toast.makeText(this,account.getPassword().toString(),Toast.LENGTH_LONG).show();
            if (account.getPassword().equals(password.getText().toString())) {

                Toast.makeText(this,"Your are connected",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                String message = account.getMail();
                String id = "id";
                intent.putExtra(id, message);
                startActivity(intent);

                finish();
            } else {
                if (counter == 0) {
                    Toast.makeText(this,"Please click on forgot password",Toast.LENGTH_LONG).show();
                    b1.setEnabled(false);
                }
                else {
                    counter--;
                    Toast.makeText(this,counter+" Attempt left",Toast.LENGTH_LONG).show();
                }
            }
        }
        accountBDD.close();
    }

    public void StartRegActivity(View v){
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        finish();
    }

    public void StartPwdFActivity(View v){
        //startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

}
