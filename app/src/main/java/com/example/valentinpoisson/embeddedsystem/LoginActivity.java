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
import com.example.valentinpoisson.embeddedsystem.BDD.BDD;
import com.example.valentinpoisson.embeddedsystem.dummy.Navigation;
/*
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.widget.LoginButton;
import com.facebook.CallbackManager;
*/

public class LoginActivity extends AppCompatActivity {

    TextView tx1;
    Button b1;
    EditText username,password;
    int counter = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        //facebookAPPID = 366387440607838;
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");

        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });


        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });
        */

        setContentView(R.layout.activity_login);

        b1 = (Button)findViewById(R.id.button);
        username = (EditText)findViewById(R.id.EditText);
        password = (EditText)findViewById(R.id.EditText2);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

    }

    public void LoginFct (View v){

        /*
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        String message = "coucou";
        String id = "id";
        intent.putExtra(id, message);
        startActivity(intent);
        finish();
        */
        //create instance class BDD
        BDD bdd = new BDD(this);
        bdd.open();
        Account account = bdd.getAccountWithMail(username.getText().toString());

        if(account==null){
            Toast.makeText(this,"Incorrect Mail",Toast.LENGTH_LONG).show();
            bdd.close();
        } else {
            //Toast.makeText(this,account.getPassword().toString(),Toast.LENGTH_LONG).show();
            if (account.getPassword().equals(password.getText().toString())) {

                Toast.makeText(this,"Your are connected",Toast.LENGTH_LONG).show();

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                String message = account.getMail();
                String id = "id";
                intent.putExtra(id, message);
                startActivity(intent);
                bdd.close();
                finish();
            } else {
                if (counter == 0) {
                    Toast.makeText(this,"Please click on forgot password",Toast.LENGTH_LONG).show();
                    b1.setEnabled(false);
                    bdd.close();
                }
                else {
                    counter--;
                    Toast.makeText(this,counter+" Attempt left",Toast.LENGTH_LONG).show();
                    bdd.close();
                }
            }
        }

    }

    public void StartRegActivity(View v){
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }

    public void StartPwdFActivity(View v){
        //startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
    */
}
