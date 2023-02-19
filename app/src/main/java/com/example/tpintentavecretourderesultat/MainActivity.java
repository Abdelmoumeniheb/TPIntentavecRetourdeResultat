package com.example.tpintentavecretourderesultat;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText Editusername,Editpassword;
    Button btnlogin,btnsignup;

    private final static int ACCOUNT_ID=10;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == ACCOUNT_ID){
            if(resultCode == RESULT_OK){
                String username = data.getStringExtra("Login_Extra");
                String password = data.getStringExtra("password_Extra");
                Editusername.setText(username);
                Editpassword.setText(password);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Editusername=(EditText)findViewById(R.id.inputusername);
        Editpassword=(EditText)findViewById(R.id.inputpassword);
         btnlogin=((Button)findViewById(R.id.btnlogin));
         btnsignup=((Button)findViewById(R.id.btnsignup));
        btnsignup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Signup.class);
                startActivityForResult(intent,ACCOUNT_ID);
            }
        });
        btnlogin.setOnClickListener((new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(Editusername.getText().toString().equals("") || Editpassword.getText().toString().equals("")){
                            AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                            alertDialog.setTitle("Erreur you must to sign up first");
                            alertDialog.show();
                        }
                        else{
                            Intent i = new Intent(MainActivity.this,HomeAcitivity.class);
                            startActivity(i);
                        }
                    }}
                )
        );
    }




}