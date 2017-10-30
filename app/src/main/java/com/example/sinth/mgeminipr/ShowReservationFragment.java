package com.example.sinth.mgeminipr;

<<<<<<< HEAD:app/src/main/java/com/example/sinth/mgeminipr/ReservationFragment.java
=======
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v4.app.ListFragment;
import android.support.v4.app.Fragment;
>>>>>>> Test:app/src/main/java/com/example/sinth/mgeminipr/ShowReservationFragment.java
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

public class ShowReservationFragment extends Fragment {
    private RecyclerView recyclerView;
    private IReservationClickListener myClickListener;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        myClickListener = (IReservationClickListener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_loan, container, false);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        final ReservationRecyclerAdapter reservationRecyclerAdapter = new ReservationRecyclerAdapter(myClickListener);
        reservationRecyclerAdapter.setFragment(this);

        LibraryService.getReservationsForCustomer(new Callback<List<Reservation>>() {
            @Override
            public void onCompletion(List<Reservation> input) {
<<<<<<< HEAD:app/src/main/java/com/example/sinth/mgeminipr/ReservationFragment.java

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
=======
                reservationRecyclerAdapter.setItems(input);
                recyclerView.setAdapter(reservationRecyclerAdapter);
>>>>>>> Test:app/src/main/java/com/example/sinth/mgeminipr/ShowReservationFragment.java
            }

            @Override
            public void onError(String message) {
                Log.d(message, message);
            }
        });

        return recyclerView;
    }
}