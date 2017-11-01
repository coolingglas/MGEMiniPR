package com.example.sinth.mgeminipr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import service.Callback;
import service.LibraryService;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LibraryService.setServerAddress("http://mge1.dev.ifs.hsr.ch/public");

        setContentView(R.layout.activity_login);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextEMail = (EditText) findViewById(R.id.editTextEMail);
                EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);

                String email = editTextEMail.getText().toString();
                String password = editTextPassword.getText().toString();

                LibraryService.login(email, password, new Callback<Boolean>() {
                    @Override
                    public void onCompletion(Boolean input) {
                        if(input){
                            Intent intent = new Intent(LoginActivity.this, GadgetsActivity.class);
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onError(String message) {
                        Log.e("Error", message);
                        TextView textViewError = (TextView) findViewById(R.id.textViewError);
                        textViewError.setText("Benutzer nicht vorhanden");
                    }
                });
            }
        });

        Button btnRegistration = (Button) findViewById(R.id.btnRegistration);
        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        Switch switchSchool = (Switch) findViewById(R.id.switchSchool);
        switchSchool.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(!isChecked) {
                    LibraryService.setServerAddress("http://mge1.dev.ifs.hsr.ch/public");
                } else {
                    LibraryService.setServerAddress("http://mge2.dev.ifs.hsr.ch/public");
                }
            }
        });
    }
}