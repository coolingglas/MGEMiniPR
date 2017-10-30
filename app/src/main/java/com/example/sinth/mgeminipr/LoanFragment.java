package com.example.sinth.mgeminipr;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import domain.Loan;
import service.Callback;
import service.LibraryService;

public class LoanFragment extends Fragment {
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_loan, container, false);

        LibraryService.getLoansForCustomer(new Callback<List<Loan>>() {
            @Override
            public void onCompletion(List<Loan> input) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                LoanRecyclerAdapter loanRecyclerAdapter = new LoanRecyclerAdapter(input);
                recyclerView.setAdapter(loanRecyclerAdapter);
            }

            @Override
            public void onError(String message) {
                Log.d(message, message);
            }
        });

        /*LibraryService.getGadgets(new Callback<List<Gadget>>() {
            @Override
            public void onCompletion(List<Gadget> input) {
                List<String> items = new ArrayList<>();
                for(int i = 0; i < input.size(); i++) {
                    items.add(input.get(i).getName());
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(items);
                recyclerView.setAdapter(recyclerAdapter);
            }

            @Override
            public void onError(String message) {

            }
        });*/

        return recyclerView;
    }
}
