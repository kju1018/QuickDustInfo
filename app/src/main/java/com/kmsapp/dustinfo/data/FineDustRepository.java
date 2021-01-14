package com.kmsapp.dustinfo.data;

import com.kmsapp.dustinfo.dust_material.FineDust;

import retrofit2.Callback;

public interface FineDustRepository {
    boolean isAvailable();
    void getFindDustData(Callback<FineDust> callback);
}
