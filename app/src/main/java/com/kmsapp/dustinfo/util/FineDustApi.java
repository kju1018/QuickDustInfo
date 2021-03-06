package com.kmsapp.dustinfo.util;

import com.kmsapp.dustinfo.dust_material.FineDust;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface FineDustApi {
    String BASE_URL = "https://api.weatherplanet.co.kr/";

    @Headers("appKey: 6b200e091d1a4d7e83fb9b4732809b33")
    @GET("weather/dust?version=1")
    Call<FineDust> getFineDust(@Query("lat") double latiude,
                               @Query("lon") double longitude);
}
