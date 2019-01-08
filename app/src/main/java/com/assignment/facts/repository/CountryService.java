package com.assignment.facts.repository;

import com.assignment.facts.Constants;
import com.assignment.facts.FactsApp;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class to create service.
 */
public class CountryService {

    @Inject
    OkHttpClient okHttpClient;

    @Inject
    Constants constants;

    public CountryService() {
        FactsApp.getApp().getAppComponent().inject(this);
    }

    public ServiceApi createService() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(constants.getBaseUrl());

        return builder.build().create(ServiceApi.class);
    }
}
