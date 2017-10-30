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

import domain.Gadget;
import service.Callback;
import service.LibraryService;

public class GadgetsFragment extends Fragment {
    private RecyclerView recyclerView;
    private OnItemSelected callback;


//fragment_loan in fragment_Gadgets anpassen

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_loan, container, false);

        LibraryService.getGadgets(new Callback<List<Gadget>>() {
            @Override
            public void onCompletion(List<Gadget> input) {
                // List<Gadget> items = new ArrayList<>();
                //for(int i = 0; i < input.size(); i++) {
                //  items.add(input.get(i).getGadget().getName());

                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                final RecyclerAdapterForGetGadgets recyclerAdapter = new RecyclerAdapterForGetGadgets(input);
                recyclerView.setAdapter(recyclerAdapter);
                recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener(){

                            @Override public void onItemClick(View view, int position) {
                                Log.d(recyclerAdapter.getItem(position).toString(),"lol");
                                startActivity(null);

                            }
                        })
                );
            }

            @Override
            public void onError(String message) {
                Log.d(message, message);
            }
        });

        return recyclerView;
    }


}