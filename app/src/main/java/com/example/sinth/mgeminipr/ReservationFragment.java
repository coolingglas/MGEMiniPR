package com.example.sinth.mgeminipr;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import domain.Reservation;
import service.Callback;
import service.LibraryService;

public class ReservationFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_loan, container, false);

        LibraryService.getReservationsForCustomer(new Callback<List<Reservation>>() {
            @Override
            public void onCompletion(List<Reservation> input) {
                List<String> items = new ArrayList<>();
                for(int i = 0; i < input.size(); i++) {
                    items.add(input.get(i).getGadget().getName());
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(items);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onError(String message) {
                Log.d(message, message);
            }
        });

        return recyclerView;
    }
}