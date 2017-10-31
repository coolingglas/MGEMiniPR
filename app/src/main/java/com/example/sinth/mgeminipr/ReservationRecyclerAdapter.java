package com.example.sinth.mgeminipr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import domain.Reservation;

public class ReservationRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Reservation> items;
    private IReservationClickListener listener;

    public ReservationRecyclerAdapter(IReservationClickListener listener){
        this.listener = listener;
    }

    public void setItems(List<Reservation> itemList) {
        items = itemList;
    }

    public static class RecyclerItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;
        private Reservation reservation;

        public RecyclerItemViewHolder(final View parent, TextView itemTextView) {
            super(parent);
            textView = itemTextView;
            textView.setTag(this);
        }

        public void setItemText(CharSequence text) {
            textView.setText(text);
        }
        public void setReservation(Reservation reservation) { this.reservation = reservation; }
        public Reservation getReservation() { return reservation; }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        TextView itemTextView = (TextView) view.findViewById(R.id.itemTextView);
        itemTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerItemViewHolder viewHolder = (RecyclerItemViewHolder) v.getTag();
                listener.onReservationClicked(viewHolder.getReservation());
            }
        });

        return new RecyclerItemViewHolder(view, itemTextView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerItemViewHolder holder = (RecyclerItemViewHolder) viewHolder;
        String itemText = items.get(position).getGadget().getName();
        Reservation itemReservation = items.get(position);
        holder.setItemText(itemText);
        holder.setReservation(itemReservation);

    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
}