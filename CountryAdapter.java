package com.example.myweathernew;

import java.util.ArrayList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.viewHolder> {
    ArrayList<CountryDomain> items;

    Context context;

    public CountryAdapter(ArrayList<CountryDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CountryAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_country,parent,false);
        context = parent.getContext();
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryAdapter.viewHolder holder, int position) {
        holder.countryTxt.setText(items.get(position).getCountry());
        holder.lowTxt.setText(items.get(position).getLowTemp() + "");
        holder.highTxt.setText(items.get(position).getHighTemp() + "");

        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(items.get(position).getPicPath(), "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context).load(drawableResourceId).into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView lowTxt,highTxt,countryTxt;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            countryTxt = itemView.findViewById(R.id.countryTxt);
            highTxt = itemView.findViewById(R.id.highTxt);
            lowTxt = itemView.findViewById(R.id.lowTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
