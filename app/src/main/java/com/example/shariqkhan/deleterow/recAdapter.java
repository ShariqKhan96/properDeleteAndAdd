package com.example.shariqkhan.deleterow;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ShariqKhan on 1/21/2018.
 */

class recAdapter extends android.support.v7.widget.RecyclerView.Adapter<recAdapter.ViewHolder> {

    ArrayList<model> arrayList = new ArrayList<>();
    Context context;

    public recAdapter(ArrayList<model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,  int position) {

        final model m = arrayList.get(holder.getAdapterPosition());
        holder.txt1.setText(m.getId());
        holder.txt2.setText(m.getEmail());

        holder.b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateArrayList(arrayList.get(holder.getAdapterPosition()), holder.getAdapterPosition(), m.getId());
                Log.e("positionAdapter", String.valueOf(holder.getAdapterPosition()));
            }
        });

    }

    private void updateArrayList(model model, int position, String id) {

        arrayList.remove(model);
        try {
            notifyItemRemoved(position);
            //  notifyDataSetChanged();
        } catch (Exception e) {

            notifyItemRemoved(position);
            //notifyDataSetChanged();
        }

        Toast.makeText(context, id, Toast.LENGTH_SHORT).show();
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txt1;
        TextView txt2;
        Button b1;
        View view;


        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            txt1 = view.findViewById(R.id.textView);
            txt2 = view.findViewById(R.id.textView2);
            b1 = view.findViewById(R.id.button);

        }
    }
}
