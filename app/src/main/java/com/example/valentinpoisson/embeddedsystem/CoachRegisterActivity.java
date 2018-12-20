package com.example.valentinpoisson.embeddedsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.Toast;

import com.example.valentinpoisson.embeddedsystem.BDD.Account;
import com.example.valentinpoisson.embeddedsystem.BDD.AccountBDD;

import java.util.ArrayList;
import java.util.List;


public class CoachRegisterActivity extends AppCompatActivity {

    EditText mail,password,confirmpwd;
    Switch switchR;
    ListView lsports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coachregister);

        mail = (EditText)findViewById(R.id.mail);
        password = (EditText)findViewById(R.id.password);
        confirmpwd = (EditText)findViewById(R.id.confirmpwd);
        switchR = (Switch)findViewById(R.id.switch1);
        switchR.setChecked(true);

        lsports = (ListView) findViewById(R.id.sports);

        List<String> ArraySports = new ArrayList<String>();
        ArraySports.add("Ping Pong");
        ArraySports.add("Tennis");
        ArraySports.add("Judo");
        ArraySports.add("Foot");
        ArraySports.add("Basket");
        ArraySports.add("Taekwondo");
        ArraySports.add("Karate");
        ArraySports.add("Natation");
        ArraySports.add("Rugby");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                ArraySports );

        lsports.setAdapter(arrayAdapter);
    }

    public void StartHomeActivity(View v){

        if(password.getText().toString().equals(confirmpwd.getText().toString())){
            //create instance class BDD
            AccountBDD accountBDD = new AccountBDD(this);

            Account account = new Account(mail.getText().toString(),password.getText().toString());
            accountBDD.open();
            accountBDD.insertAccount(account);
            accountBDD.close();

            Toast.makeText(this,"Your account is created",Toast.LENGTH_LONG).show();
            //Toast.makeText(this,"Your are connected",Toast.LENGTH_LONG).show();

            startActivity(new Intent(CoachRegisterActivity.this, LoginActivity.class));
            finish();
        } else {
            Toast.makeText(this,"Password mistake",Toast.LENGTH_LONG).show();
        }
    }

    public void SwitchRegister(View v){
        if(!switchR.isChecked()){
            Toast.makeText(this,"Student Register",Toast.LENGTH_LONG).show();
            startActivity(new Intent(CoachRegisterActivity.this, RegisterActivity.class));
            finish();
        }
    }

}
