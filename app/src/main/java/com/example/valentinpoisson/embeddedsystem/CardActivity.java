package com.example.valentinpoisson.embeddedsystem;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
    TextView Phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        Name1 = (TextView) findViewById(R.id.NameField);
        Phone = (TextView) findViewById(R.id.Phone);

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

    public void alert(View v){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(CardActivity.this);
        builder.setMessage("Call or SMS ?")
                .setPositiveButton("Phone Call", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        callIntent.setData(Uri.parse("tel: " + Phone.getText().toString()));
                        try {
                            startActivity(callIntent);
                        } catch(android.content.ActivityNotFoundException ex) {
                            //
                        }
                    }
                })
                .setNegativeButton("SMS", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent smsIntent = new Intent(Intent.ACTION_VIEW);
                        smsIntent.setData(Uri.parse("SMS to: " + ""));
                        smsIntent.putExtra("address",Phone.getText().toString());
                        try {
                            startActivity(smsIntent);
                        } catch(android.content.ActivityNotFoundException ex) {
                            //
                        }
                    }
                })
                .show();

    }

}