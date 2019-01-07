package com.assignment.facts.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.assignment.facts.data.CountryData;
import com.assignment.facts.repository.Repository;

public class MainViewModel extends ViewModel {

    private LiveData<CountryData> countryData;

    public MainViewModel() {

    }

    /**
     * Load countryData.
     *
     * @return observable CountryData
     */
    public LiveData<CountryData> getCountryLiveData() {
        return countryData;
    }

    public void refresh() {
        countryData = new Repository().getData();
    }

}
