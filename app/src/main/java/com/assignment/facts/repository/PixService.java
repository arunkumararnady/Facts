package com.assignment.facts.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class to creates pixservice.
 */
public class PixService {

    public static ServiceApi createService() {
        Retrofit.Builder builder = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/");

        return builder.build().create(ServiceApi.class);
    }
}
