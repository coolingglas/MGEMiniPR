package com.example.sinth.mgeminipr;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sinth on 16.10.2017.
 */

public class MyArrayAdapterForReservations<Reservation> extends ArrayAdapter {

      List<Reservation> reservations;

    public MyArrayAdapterForReservations(Context context, int resource, int textViewResourceId, List<Reservation> reservations){
        super(context, resource, textViewResourceId, reservations);
        this.reservations = reservations;
    }

    //@override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
         domain.Reservation reservation = (domain.Reservation) reservations.get(position);


        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout_row, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.label);
        //CheckBox checkBox = convertView.findViewById(R.id.checkBox);

        textView.setText( reservation.getReservationId() + " " + reservation.getGadget());
        //checkBox.setText(module.getName());
        //checkBox.setChecked(module.isSelected());

        return convertView;
    }

   // public void setList (List<Gadget> gadgets){
    //    this.gadgets = gadgets;
    //}
}
