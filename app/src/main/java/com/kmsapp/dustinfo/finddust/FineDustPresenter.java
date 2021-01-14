package com.kmsapp.dustinfo.finddust;

import com.kmsapp.dustinfo.data.FineDustRepository;
import com.kmsapp.dustinfo.dust_material.FineDust;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//로직은 다 Presenter로
public class FineDustPresenter implements FineDustContract.UserActionsListener{

    private final FineDustRepository mRepository;
    private final FineDustContract.View mView;

    public FineDustPresenter(FineDustRepository mRepository, FineDustContract.View mView) {
        this.mRepository = mRepository;
        this.mView = mView;
    }

    @Override
    public void loadFineDustData() {
        if(mRepository.isAvailable()) {
            mView.loadingStart();
            mRepository.getFindDustData(new Callback<FineDust>() {
                @Override
                public void onResponse(Call<FineDust> call, Response<FineDust> response) {
                    mView.showFineDustResult(response.body());
                    mView.loadingEnd();
                }

                @Override
                public void onFailure(Call<FineDust> call, Throwable t) {
                    mView.showLoadError(t.getLocalizedMessage());
                    mView.loadingEnd();
                }
            });
        }
    }
}
