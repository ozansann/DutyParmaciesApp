package com.od.dutyparmaciesapp.Retrofit;

import com.od.dutyparmaciesapp.Models.PharmacyModel;
import com.od.dutyparmaciesapp.Models.ResultModel;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ApiRequest {
    @GET("pharmacy/distance")
    Call<ResultModel<ArrayList<PharmacyModel>>> getNearestPharmacy(@Header("Content-Type") String contentType,
                                                                   @Header("Authorization") String apiKey,
                                                                   @Query("latitude") Double latitude,
                                                                   @Query("longitude") Double longitude);
}