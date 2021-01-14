package com.kmsapp.dustinfo.data;

import com.kmsapp.dustinfo.dust_material.FineDust;
import com.kmsapp.dustinfo.util.FineDustUtil;

import retrofit2.Callback;

public class LocationFineDustRepository implements FineDustRepository{

    private FineDustUtil mFineDustUtil;
    private double mLatitude;
    private double mLongitude;

    public LocationFineDustRepository() {
        mFineDustUtil = new FineDustUtil();
    }

    public LocationFineDustRepository(double lat, double lng) {
        this();//기본생성자도 호출
        this.mLatitude = lat;
        this.mLongitude = lng;
    }

    @Override
    public boolean isAvailable() {
        if(mLatitude != 0.0 && mLongitude != 0.0)
            return true;

        return false;
    }

    @Override
    public void getFindDustData(Callback<FineDust> callback) {
            mFineDustUtil.getApi().getFineDust(mLatitude, mLongitude)
                    .enqueue(callback);
            //enqueue 비동기
    }
}
