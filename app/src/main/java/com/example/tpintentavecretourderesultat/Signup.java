package com.example.tpintentavecretourderesultat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity{
    EditText username,password;
    Button btnsignup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username=(EditText)findViewById(R.id.inputusername);
        password=(EditText)findViewById(R.id.inputpassword);
        btnsignup=((Button)findViewById(R.id.btnsignup));
        btnsignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                gotToMain();
            }
        });
    }
    public void gotToMain(){
        Intent resultatItent = new Intent();
        resultatItent.putExtra("Login_Extra",username.getText().toString());
        resultatItent.putExtra("password_Extra",password.getText().toString());
        setResult(RESULT_OK,resultatItent);
        finish();
    }

}