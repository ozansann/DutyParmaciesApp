package com.od.dutyparmaciesapp.Fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.od.dutyparmaciesapp.databinding.AllPharmacyListFragmentBinding;

public class AllPharmacyListFragment extends BaseFragment {
    AllPharmacyListFragmentBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(getContext(),"NOT DONE YET!",Toast.LENGTH_LONG);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = AllPharmacyListFragmentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
}