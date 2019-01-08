package com.assignment.facts.repository;

import com.assignment.facts.data.CountryData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApi {

    @GET("facts.js")
    Call<CountryData> getCountryData();

}
