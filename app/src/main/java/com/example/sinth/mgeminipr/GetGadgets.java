package com.example.sinth.mgeminipr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.List;

import domain.Gadget;
import service.Callback;
import service.LibraryService;

public class GetGadgets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gadgets_sinthu);

        LibraryService.getGadgets(new Callback<List<Gadget>>() {
            @Override
            public void onCompletion(List<Gadget> input) {

                final ListView view = (ListView) findViewById(R.id.gadgets);

                LibraryService.reserveGadget(input.get(0), new Callback<Boolean>() {
                    @Override
                    public void onCompletion(Boolean input) {

                    }

                    @Override
                    public void onError(String message) {

                    }
                });

                view.findViewById(R.id.gadgets);
            }

            @Override
            public void onError(String message) {
                Log.d(message, message);
            }
        });
    }
}