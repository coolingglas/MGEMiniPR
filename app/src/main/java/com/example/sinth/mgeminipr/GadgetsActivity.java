package com.example.sinth.mgeminipr;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import domain.Gadget;
import domain.Reservation;
import service.Callback;
import service.LibraryService;

public class GadgetsActivity extends AppCompatActivity implements IReservationClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gadgets);

        loadFragments();
    }

    private void loadFragments() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
<<<<<<< HEAD
        adapter.addFragment(new GadgetsFragment(), "Loans");
        adapter.addFragment(new ReservationFragment(), "Reservations");
=======
        adapter.addFragment(new ShowReservationFragment(), "Reservations");
        adapter.addFragment(new LoanFragment(), "Loans");
>>>>>>> Test
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onReservationClicked(Reservation reservation) {
        LibraryService.deleteReservation(reservation, new Callback<Boolean>() {
            @Override
            public void onCompletion(Boolean input) {
                loadFragments();
            }

            @Override
            public void onError(String message) {

            }
        });
    }
}



    // LibraryService.setServerAddress("http://mge1.dev.ifs.hsr.ch/public​");
    /*LibraryService.getGadgets(new Callback<List<Gadget>>() {
        @Override
        public void onCompletion(List<Gadget> input) {
            ListView view = (ListView) findViewById(R.id.gadgets);
            MyArrayAdapter<Gadget> arrayAdapter = new MyArrayAdapter<> (GadgetsActivity.this, R.layout.layout_row, R.id.label, input);
            view.setAdapter(arrayAdapter);
        }

        @Override
        public void onError(String message) {
            Log.d(message, message);
        }
    });*/
