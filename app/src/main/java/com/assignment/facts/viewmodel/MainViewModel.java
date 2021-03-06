package com.assignment.facts.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.ViewModel;

import com.assignment.facts.FactsApp;
import com.assignment.facts.data.CountryData;
import com.assignment.facts.repository.Repository;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    @Inject
    public Repository repository;
    private MediatorLiveData<CountryData> countryData = new MediatorLiveData<>();

    public MainViewModel() {
        FactsApp.getApp().getAppComponent().inject(this);
        countryData.addSource(repository.getData(), countryData::setValue);
    }

    /**
     * Load countryData.
     *
     * @return observable CountryData
     */
    public LiveData<CountryData> getCountryLiveData() {
        return countryData;
    }

}
