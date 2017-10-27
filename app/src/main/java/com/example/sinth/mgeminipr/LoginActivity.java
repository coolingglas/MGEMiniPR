package com.example.sinth.mgeminipr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import service.Callback;
import service.LibraryService;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gadgets);
        LibraryService.setServerAddress("http://mge1.dev.ifs.hsr.ch/public");
        /*LibraryService.register("guesel", "guesel", "guesel", "guesel", new Callback<Boolean>() {
            @Override
            public void onCompletion(Boolean input) {
                if(input){
                    Log.d("Top", "Register");
                } else {
                    Log.d("Nope", "Register");

                }
            }

            @Override
            public void onError(String message) {
                Log.d("tja", "tja");
            }
        });
       /*LibraryService.logout(new Callback<Boolean>() {
           @Override
           public void onCompletion(Boolean input) {
               if(input) {
                   Log.d("logout", "erfolgreich");
               }else{
                   Log.d("logout", "nef");

               }
           }

           @Override
           public void onError(String message) {

           }
       });*/
        LibraryService.login("guesel", "guesel", new Callback<Boolean>() {
            @Override
            public void onCompletion(Boolean input) {
                if(input){
                    Log.d("Top", "Login");
                    Intent i = new Intent(LoginActivity.this, GadgetsActivity.class);
                    startActivity(i);

                } else {
                    Log.d("Flop", "Login");
                }

            }

            @Override
            public void onError(String message) {
                Log.e("Error", message);
            }
        });




    }
}
