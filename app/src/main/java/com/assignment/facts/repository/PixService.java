package com.assignment.facts.repository;

import com.assignment.facts.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class to creates pixservice.
 */
public class PixService {

    public static ServiceApi createService() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.getBaseUrl());

        return builder.build().create(ServiceApi.class);
    }
}
