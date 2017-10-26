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

public class MyArrayAdapter<Gadget> extends ArrayAdapter {

      List<Gadget> gadgets;

    public MyArrayAdapter(Context context, int resource, int textViewResourceId, List<Gadget> objects){
        super(context, resource, textViewResourceId, objects);
        gadgets = objects;
    }

    //@override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
         domain.Gadget gadget = (domain.Gadget) gadgets.get(position);

        gadget.getClass();

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.layout_row, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.label);
        //CheckBox checkBox = convertView.findViewById(R.id.checkBox);

        textView.setText( gadget.getName() + " " + gadget.getManufacturer());
        //checkBox.setText(module.getName());
        //checkBox.setChecked(module.isSelected());

        return convertView;
    }

    public void setList (List<Gadget> gadgets){
        this.gadgets = gadgets;
    }
}
