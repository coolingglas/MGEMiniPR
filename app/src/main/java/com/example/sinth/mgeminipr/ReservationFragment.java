package com.example.sinth.mgeminipr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

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

                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                RecyclerAdapterForReservations recyclerAdapterForReservations = new RecyclerAdapterForReservations(input);
                recyclerView.setAdapter(recyclerAdapterForReservations);

                recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                    @Override
                    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                        return false;
                    }

                    @Override
                    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

                    }

                    @Override
                    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

                    }
                });
            }

            @Override
            public void onError(String message) {
                Log.d(message, message);
            }
        });

        return recyclerView;
    }
}