package com.od.dutyparmaciesapp.Fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.od.dutyparmaciesapp.Adapters.PharmacyAdapter;
import com.od.dutyparmaciesapp.Helpers.RecyclerTouchListener;
import com.od.dutyparmaciesapp.Models.PharmacyModel;
import com.od.dutyparmaciesapp.R;
import com.od.dutyparmaciesapp.ViewModels.PharmacyViewModel;
import com.od.dutyparmaciesapp.databinding.FragmentMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends BaseFragment {
    FragmentMainBinding binding;
    private FusedLocationProviderClient fusedLocationClient;
    private LinearLayoutManager layoutManager;
    private PharmacyAdapter adapter;
    private ArrayList<PharmacyModel> pharmacyArrayList;
    private List<PharmacyModel> pharmacyList;
    private PharmacyViewModel pharmacyViewModel;
    private Bundle bundle;
    private Double latitude, longitude;

    ActivityResultLauncher<String[]> locationPermissionRequest =
            registerForActivityResult(new ActivityResultContracts
                            .RequestMultiplePermissions(), result -> {
                        Boolean fineLocationGranted = result.getOrDefault(
                                Manifest.permission.ACCESS_FINE_LOCATION, false);
                        Boolean coarseLocationGranted = result.getOrDefault(
                                Manifest.permission.ACCESS_COARSE_LOCATION, false);
                        if (fineLocationGranted != null && fineLocationGranted) {
                            getLocation();
                        } else if (coarseLocationGranted != null && coarseLocationGranted) {
                            getLocation();
                        } else {
                            Log.d("NotGranted", "Permissions not granted!");
                        }
                    }
            );


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pharmacyArrayList = new ArrayList<>();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        checkLocationPermissions();
        initializeComponents();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void checkLocationPermissions(){
        locationPermissionRequest.launch(new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.CALL_PHONE
        });
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(getContext());
        swipeRefresh();
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        fusedLocationClient.getLastLocation().addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            latitude = location.getLatitude();
                            longitude = location.getLongitude();
                            getNearestPharmacyList();
                        }
                    }
                });
    }

    private void initializeComponents() {
        layoutManager = new LinearLayoutManager(getContext());
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setHasFixedSize(false);
        adapter = new PharmacyAdapter(getContext(), pharmacyArrayList);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getContext(), binding.recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                bundle = new Bundle();
                bundle.putSerializable("selectedPharmacy",pharmacyArrayList.get(position));
                navigateWithBundle(R.id.action_mainFragment_to_pharmacyDetailFragment,bundle);
            }
        }));
        pharmacyViewModel = ViewModelProviders.of(this).get(PharmacyViewModel.class);
        //pharmacyViewModel = new ViewModelProvider(this, new PharmacyViewModel(getActivity().getApplication(), latitude,longitude)).get(PharmacyViewModel.class);

    }

    private void swipeRefresh() {
        binding.swipeRefresh.setOnRefreshListener(() -> {
            binding.swipeRefresh.setRefreshing(false);
            getNearestPharmacyList();
        });
    }

    private void getNearestPharmacyList() {
        pharmacyViewModel.getNearestPharmacyResponseLiveData(latitude,longitude).observe(getActivity(), planetResponse -> {
            if (planetResponse != null && !planetResponse.isEmpty()) {
                pharmacyList = planetResponse;
                pharmacyArrayList.clear();
                pharmacyArrayList.addAll(pharmacyList);
                adapter.notifyDataSetChanged();
                binding.dummyPharmacies.setVisibility(View.GONE);
            } else{
                Toast.makeText(getContext(),"Hata", Toast.LENGTH_SHORT).show();
            }
        });
    }
}