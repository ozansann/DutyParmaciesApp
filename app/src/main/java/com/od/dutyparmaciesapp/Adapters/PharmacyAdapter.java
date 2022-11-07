package com.od.dutyparmaciesapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.od.dutyparmaciesapp.Models.PharmacyModel;
import com.od.dutyparmaciesapp.databinding.RowPharmacyBinding;

import java.util.ArrayList;

public class PharmacyAdapter extends RecyclerView.Adapter<PharmacyAdapter.ViewHolder> {
    private final Context context;
    private ArrayList<PharmacyModel> pharmacyList;

    public PharmacyAdapter(Context context, ArrayList<PharmacyModel> pharmacyList) {
        this.context = context;
        this.pharmacyList = pharmacyList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(RowPharmacyBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        PharmacyModel pharmacy = pharmacyList.get(i);
        viewHolder.binding.tvPharmacyName.setText(pharmacy.getName());
        viewHolder.binding.tvPharmacyPhone.setText(pharmacy.getPhone1());
        viewHolder.binding.tvPharmacyAddress.setText(pharmacy.getAddress());
    }

    @Override
    public int getItemCount() {
        return pharmacyList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private RowPharmacyBinding binding;

        public ViewHolder(RowPharmacyBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
