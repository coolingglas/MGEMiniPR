package com.example.sinth.mgeminipr;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class GadgetsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gadgets);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LoanFragment(), "Loans");
        adapter.addFragment(new ReservationFragment(), "Reservations");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
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
