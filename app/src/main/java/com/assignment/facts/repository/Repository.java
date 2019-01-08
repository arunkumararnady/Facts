package com.assignment.facts.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.assignment.facts.utils.LogUtil;
import com.assignment.facts.data.CountryData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private ServiceApi mServiceApi;

    public Repository() {
        mServiceApi = (new CountryService()).createService();
    }

    public LiveData<CountryData> getData() {
        final MutableLiveData<CountryData> data = new MutableLiveData<>();
        mServiceApi.getCountryData().enqueue(new Callback<CountryData>() {
            @Override
            public void onResponse(Call<CountryData> call, Response<CountryData> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CountryData> call, Throwable t) {
                LogUtil.error(Repository.class.getName(), "Server request failed : "+t.getMessage());
            }
        });
        return data;
    }
}
