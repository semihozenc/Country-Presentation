package com.semih.firstjavaproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.semih.firstjavaproject.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class cityAdaptor extends RecyclerView.Adapter<cityAdaptor.cityHolder> {

    ArrayList<city> cityArrayList;

    public cityAdaptor(ArrayList<city> cityArrayList, Context context) {
        this.cityArrayList = cityArrayList;
    }

    @NonNull
    @Override
    public cityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new cityHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull cityHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(cityArrayList.get(position).sehirName);
    }

    @Override
    public int getItemCount() {
        return cityArrayList.size();
    }

    public class cityHolder extends RecyclerView.ViewHolder {
        private RecyclerRowBinding binding;

        public cityHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
