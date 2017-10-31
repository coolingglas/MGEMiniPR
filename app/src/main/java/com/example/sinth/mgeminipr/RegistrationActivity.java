package com.example.sinth.mgeminipr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import service.Callback;
import service.LibraryService;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        Button btnRegistrieren = (Button) findViewById(R.id.btnRegistration);
        btnRegistrieren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextEMail = (EditText) findViewById(R.id.editTextEMail);
                EditText editTextPassword = (EditText) findViewById(R.id.editTextPassword);
                EditText editTextName = (EditText) findViewById(R.id.editTextName);
                EditText editTextStudentNumber = (EditText) findViewById(R.id.editTextStudentNumber);

                String eMail = editTextEMail.getText().toString();
                String password = editTextPassword.getText().toString();
                String name = editTextName.getText().toString();
                String studentNumber = editTextStudentNumber.getText().toString();

                LibraryService.register(eMail, password, name, studentNumber, new Callback<Boolean>() {
                    @Override
                    public void onCompletion(Boolean input) {
                        if(input) {
                            finish();
                        }
                    }

                    @Override
                    public void onError(String message) {
                        Log.e("Error", message);
                    }
                });
            }
        });
    }
}

