package com.od.dutyparmaciesapp.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.od.dutyparmaciesapp.Models.PharmacyModel;
import com.od.dutyparmaciesapp.Models.ResultModel;
import com.od.dutyparmaciesapp.Repositories.PharmacyRepository;

import java.util.ArrayList;

public class PharmacyViewModel extends AndroidViewModel {
    private PharmacyRepository planetResponse;
    private LiveData<ArrayList<PharmacyModel>> planetResponseLiveData;
    private Double latitude,longitude;

    public PharmacyViewModel(@NonNull Application application) {
        super(application);
        planetResponse = new PharmacyRepository();
        this.planetResponseLiveData = planetResponse.getNearestPharmacy(latitude,longitude);
    }

    public LiveData<ArrayList<PharmacyModel>> getNearestPharmacyResponseLiveData(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.planetResponseLiveData = planetResponse.getNearestPharmacy(latitude,longitude);
        return planetResponseLiveData;
    }
}
