package com.example.sinth.mgeminipr;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import domain.Gadget;
import domain.Reservation;
import service.Callback;
import service.LibraryService;

public class GetGadgets extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_gatets_activity);

       // LibraryService.setServerAddress("http://mge1.dev.ifs.hsr.ch/public​");
        LibraryService.getGadgets(new Callback<List<Gadget>>() {
            @Override
            public void onCompletion(List<Gadget> input) {

                final ListView view = (ListView) findViewById(R.id.gadgets);

                //MyArrayAdapter<Gadget> arrayAdapter = new MyArrayAdapter<> (GetGadgets.this, R.layout.layout_row, R.id.label, input);

               // TextView v = (TextView) findViewById(R.id.);

                //view.setAdapter(arrayAdapter);





//Gadget Reservieren
                LibraryService.reserveGadget(input.get(0), new Callback<Boolean>() {
                            @Override
                            public void onCompletion(Boolean input) {
                                LibraryService.getReservationsForCustomer(new Callback<List<Reservation>>() {
                                    @Override
                                    public void onCompletion(List<Reservation> input) {
                                        MyArrayAdapterForReservations<Reservation>  adapterForReservations = new MyArrayAdapterForReservations<Reservation>(GetGadgets.this, R.layout.layout_row, R.id.label, input);

                                        view.setAdapter(adapterForReservations);

                                        view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                Reservation reservation = (Reservation) parent.getItemAtPosition(position);
                                                //reservation.setSelected(!module.isSelected());
                                               // dataAdapter.notifyDataSetChanged();

                                               // LibraryService.deleteReservation(new Callback<boolean>());
                                            }
                                        });


                                    }

                                    @Override
                                    public void onError(String message) {

                                    }
                                });
                            }

                            @Override
                            public void onError(String message) {

                            }
                        }
                );

                view.findViewById(R.id.gadgets);

            }

            @Override
            public void onError(String message) {
                Log.d(message, message);
            }
        });
        /*LibraryService.getGadgets(new Callback<List<Gadget>>() {
            @Override
            public void onCompletion(List<Gadget> input) {
                ListView view = (ListView) findViewById(R.id.listView);
                ArrayAdapter<Gadget> arrayAdapter = new ArrayAdapter<> (view.getContext(), android.R.layout.simple_list_item_1, input);
                view.setAdapter(arrayAdapter);
            }

            @Override
            public void onError(String message) {

            }
        });*/
    }
}
