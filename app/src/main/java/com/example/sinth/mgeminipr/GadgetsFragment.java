package com.example.sinth.mgeminipr;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import domain.Gadget;
import service.Callback;
import service.LibraryService;

public class GadgetsFragment extends Fragment {
    private RecyclerView recyclerView;
    private IGadgetsClickListener callback;

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        callback = (IGadgetsClickListener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_gadgets, container, false);

        LibraryService.getGadgets(new Callback<List<Gadget>>() {
            @Override
            public void onCompletion(List<Gadget> input) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                final RecyclerAdapterForGetGadgets recyclerAdapter = new RecyclerAdapterForGetGadgets(input, callback);
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