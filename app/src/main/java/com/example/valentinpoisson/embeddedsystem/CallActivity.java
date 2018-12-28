package com.example.valentinpoisson.embeddedsystem;

/**
 * Created by valentinpoisson on 24/12/2018.
 */

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build;
import android.telecom.Call;
import android.widget.Button;
import android.support.v4.content.ContextCompat;
import android.widget.EditText;
import android.util.Log;
import android.Manifest;
import android.content.pm.PackageManager;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class CallActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE = 1;
    private Button sendSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        Bundle position = getIntent().getExtras();
        String num = position.getString("id");

        TextView phoneNum= (TextView) findViewById(R.id.phoneNumber);
        phoneNum.setText(num);
        final TextView phoneNumber = phoneNum;

        if (Build.VERSION.SDK_INT >= 23) {
            if (checkPermission()) {
                Log.e("permission", "Permission already granted.");
            } else {
                requestPermission();
            }
        }

        final EditText smsText = (EditText) findViewById(R.id.message);
        sendSMS = (Button) findViewById(R.id.sendSMS);
        sendSMS.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String sms = phoneNumber.getText().toString() ;//smsText.getText().toString();
                String phoneNum = phoneNumber.getText().toString();
                if(!TextUtils.isEmpty(sms) && !TextUtils.isEmpty(phoneNum)) {
                    if(checkPermission()) {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phoneNum, null, sms, null, null);
                    }else {
                        Toast.makeText(CallActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(CallActivity.this, Manifest.permission.SEND_SMS);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, PERMISSION_REQUEST_CODE);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(CallActivity.this,
                            "Permission accepted", Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(CallActivity.this,
                            "Permission denied", Toast.LENGTH_LONG).show();
                    Button sendSMS = (Button) findViewById(R.id.sendSMS);
                    sendSMS.setEnabled(false);

                }
                break;
        }
    }

    public void makeCall(View v){
        AlertDialog.Builder builder;
        builder = new AlertDialog.Builder(CallActivity.this);
        builder.setMessage("Call or SMS ?")
                .setPositiveButton("Phone Call", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent callIntent = new Intent(Intent.ACTION_CALL);
                        //callIntent.setData(Uri.parse("tel: " + phone.getText().toString()));
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
                        //smsIntent.putExtra("address",phone.getText().toString());
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