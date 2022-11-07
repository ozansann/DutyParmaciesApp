package com.od.dutyparmaciesapp.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.od.dutyparmaciesapp.Models.PharmacyModel;
import com.od.dutyparmaciesapp.R;
import com.od.dutyparmaciesapp.databinding.FragmentPharmacyDetailBinding;

public class PharmacyDetailFragment extends BaseFragment{
    FragmentPharmacyDetailBinding binding;
    private PharmacyModel selectedPharmacy;
    Intent callIntent;
    private String phoneNumber;
    private Bundle bundle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        selectedPharmacy = (PharmacyModel) getArguments().getSerializable("selectedPharmacy");
        callIntent = new Intent(Intent.ACTION_CALL);
        phoneNumber = getFormattedPhoneNumber(selectedPharmacy.getPhone1());
        binding.btnCall.setText(selectedPharmacy.getPhone1());
        binding.txtName.setText(selectedPharmacy.getName().isEmpty() ? "-" : selectedPharmacy.getName());
        binding.txtAddress.setText(selectedPharmacy.getName().isEmpty() ? "-" : selectedPharmacy.getAddress());
        binding.txtCity.setText(selectedPharmacy.getCity().isEmpty() ? "-" : selectedPharmacy.getCity());
        binding.txtState.setText(selectedPharmacy.getState().isEmpty() ? "-" : selectedPharmacy.getState());
        binding.txtDistrict.setText(selectedPharmacy.getDistrict().isEmpty() ? "-" : selectedPharmacy.getDistrict());
        binding.txtDistance.setText(selectedPharmacy.getDistanceMt() + " " + getString(R.string.meter));
        binding.btnCall.setVisibility(View.VISIBLE);
        setOnClickListeners();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPharmacyDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    private void setOnClickListeners(){
        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callIntent.setData(Uri.parse("tel:" + phoneNumber));
                startActivity(callIntent);
            }
        });
        binding.mapsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                bundle.putString("pharmacyAddress",selectedPharmacy.getAddress());
                bundle.putDouble("pharmacyLatitude",selectedPharmacy.getLatitude());
                bundle.putDouble("pharmacyLongitude",selectedPharmacy.getLongitude());
                navigateWithBundle(R.id.action_pharmacyDetailFragment_to_googleMapsFragment,bundle);
            }
        });
    }

    public String getFormattedPhoneNumber(String phoneNumber){
        String formattedNumber = "+9";
        formattedNumber += getDigitsOfPhoneNumber(phoneNumber);
        return formattedNumber;
    }

    private String getDigitsOfPhoneNumber(String phoneNumber){
        String digitStr = "";
        for(char c : phoneNumber.toCharArray()){
            if(Character.isDigit(c)){
                digitStr += c;
            }
        }
        return digitStr;
    }
}
