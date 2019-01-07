package com.assignment.facts.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.assignment.facts.data.CountryData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    public LiveData<CountryData> getData() {
        // TODO
        final MutableLiveData<CountryData> data = new MutableLiveData<>();
        CountryService.createService().getCountryData().enqueue(new Callback<CountryData>() {
            @Override
            public void onResponse(Call<CountryData> call, Response<CountryData> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<CountryData> call, Throwable t) {
                Log.e("Repository", "server request failed");
            }

        });
        return data;
    }

}
