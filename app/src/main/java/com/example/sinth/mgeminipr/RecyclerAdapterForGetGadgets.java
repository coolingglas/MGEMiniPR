package com.example.sinth.mgeminipr;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import domain.Gadget;

public class RecyclerAdapterForGetGadgets extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Gadget> items;
    private IGadgetsClickListener listener;

    public RecyclerAdapterForGetGadgets(List<Gadget> itemList, IGadgetsClickListener listener) {
        items = itemList;
        this.listener = listener;
    }

    public static class RecyclerItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private Gadget gadget;

        public RecyclerItemViewHolder(final View parent, TextView itemTextView) {
            super(parent);
            textView = itemTextView;
            textView.setTag(this);
        }

        public void setItemText(CharSequence text) {
            textView.setText(text);
        }
        public void setGadget(Gadget gadget) { this.gadget = gadget; }
        public Gadget getGadget() { return gadget; }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       final Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        TextView itemTextView = (TextView) view.findViewById(R.id.itemTextView);
        itemTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerItemViewHolder rivh = (RecyclerItemViewHolder) v.getTag();
                listener.onItemSelected(rivh.getGadget());
            }
        });
        return new RecyclerItemViewHolder(view, itemTextView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerItemViewHolder holder = (RecyclerItemViewHolder) viewHolder;
        Gadget itemText = items.get(position);
        holder.setItemText(itemText.getName());
        holder.setGadget(itemText);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }
}