package com.example.sinth.mgeminipr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText mailEditText;
    private EditText martikelEditText;
    private EditText passWortEditText;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        nameEditText = (EditText) findViewById(R.id.nameText);
        mailEditText = (EditText) findViewById(R.id.e_mailText);
        martikelEditText = (EditText) findViewById(R.id.MartikelNumberText);
        passWortEditText = (EditText) findViewById(R.id.PasswortText);


        // view = (TextView) findViewById(R.id.nameView);
        nameEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                name = s.toString();


            }
        });
       Intent i = new Intent(this, LoginActivity.class);
       startActivity(i);
        //MustBeDone
        /*LibraryService.setServerAddress("http://mge1.dev.ifs.hsr.ch/public");
        LibraryService.register(name, "guesel", "guesel", "guesel", new Callback<Boolean>() {
            @Override
            public void onCompletion(Boolean input) {
                if (input) {
                    Log.d("Top", "Register");
                } else {
                    Log.d("Nope", "Register");

                }
            }

            @Override
            public void onError(String message) {

            }
        });*/


    }
}

