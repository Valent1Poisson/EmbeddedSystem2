package com.example.valentinpoisson.embeddedsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.example.valentinpoisson.embeddedsystem.BDD.Account;
import com.example.valentinpoisson.embeddedsystem.BDD.BDD;


public class RegisterActivity extends AppCompatActivity {

    EditText mail,password,confirmpwd;
    Switch switchR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mail = (EditText)findViewById(R.id.mail);
        password = (EditText)findViewById(R.id.password);
        confirmpwd = (EditText)findViewById(R.id.confirmpwd);
        switchR = (Switch)findViewById(R.id.switch1);
    }

    public void StartHomeActivity(View v){

        if(password.getText().toString().equals(confirmpwd.getText().toString())){
            //create instance class BDD
            BDD bdd = new BDD(this);

            Account account = new Account(0,mail.getText().toString(),password.getText().toString());
            bdd.open();
            bdd.insertAccount(account);
            bdd.close();

            Toast.makeText(this,"Your account is created",Toast.LENGTH_LONG).show();
            //Toast.makeText(this,"Your are connected",Toast.LENGTH_LONG).show();

            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        } else {
            Toast.makeText(this,"Password mistake",Toast.LENGTH_LONG).show();
        }
    }

    public void SwitchRegister(View v){
        if(switchR.isChecked()){
            Toast.makeText(this,"Coach Register",Toast.LENGTH_LONG).show();
            startActivity(new Intent(RegisterActivity.this, CoachRegisterActivity.class));
            finish();
        }
    }

}
