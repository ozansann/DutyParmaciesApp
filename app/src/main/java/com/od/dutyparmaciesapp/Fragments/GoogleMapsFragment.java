package com.od.dutyparmaciesapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.od.dutyparmaciesapp.R;

public class GoogleMapsFragment extends BaseFragment {
    String pharmacyAddress;
    Double pharmacyLatitude,pharmacyLongitude;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pharmacyLatitude = getArguments().getDouble("pharmacyLatitude");
        pharmacyLongitude = getArguments().getDouble("pharmacyLongitude");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_google_maps, container, false);
        SupportMapFragment supportMapFragment=(SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                setInitialLocation(googleMap,pharmacyLatitude,pharmacyLongitude);
            }
        });
        return view;
    }

    public void setInitialLocation(GoogleMap googleMap, Double latitude, Double longitude){
        MarkerOptions markerOptions=new MarkerOptions();
        LatLng latLng = new LatLng(latitude,longitude);
        markerOptions.position(latLng);
        markerOptions.title(getString(R.string.pharmacy_here));
        googleMap.clear();
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,15));
        googleMap.addMarker(markerOptions);
    }
}
