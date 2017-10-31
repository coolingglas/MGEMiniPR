package com.example.sinth.mgeminipr;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import domain.Gadget;
import domain.Reservation;
import service.Callback;
import service.LibraryService;

public class GadgetsActivity extends AppCompatActivity implements IReservationClickListener, IGadgetsClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gadgets);
        loadFragments();
    }

    private void loadFragments() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new ShowReservationFragment(), "Reservations");
        adapter.addFragment(new LoanFragment(), "Loans");
        adapter.addFragment(new GadgetsFragment(), "Gadgets");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

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

    @Override
    public void onItemSelected(Gadget gadget) {
        LibraryService.reserveGadget(gadget, new Callback<Boolean>() {
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