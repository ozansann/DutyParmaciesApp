package com.od.dutyparmaciesapp.Repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.od.dutyparmaciesapp.Constants.AppConstants;
import com.od.dutyparmaciesapp.Models.PharmacyModel;
import com.od.dutyparmaciesapp.Models.ResultModel;
import com.od.dutyparmaciesapp.Retrofit.ApiRequest;
import com.od.dutyparmaciesapp.Retrofit.RetrofitRequest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PharmacyRepository {
    private final ApiRequest request;
    public PharmacyRepository() {
        request = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }
    //mutableStateFlow
    public LiveData<ArrayList<PharmacyModel>> getNearestPharmacy(Double latitude, Double longitude) {
        final MutableLiveData<ArrayList<PharmacyModel>> data = new MutableLiveData<>();
        request.getNearestPharmacy("application/json",AppConstants.API_KEY,latitude,longitude)
                .enqueue(new Callback<ResultModel<ArrayList<PharmacyModel>>>() {
                    @Override
                    public void onResponse(@NonNull Call<ResultModel<ArrayList<PharmacyModel>>> call,
                                           @NonNull Response<ResultModel<ArrayList<PharmacyModel>>> response) {
                        if (response.body() != null) {
                            data.setValue(response.body().getData());
                        } else{
                            data.setValue(null);
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<ResultModel<ArrayList<PharmacyModel>>> call, @NonNull Throwable t) {
                        data.setValue(null);

                    }
                });
        return data;
    }
}
