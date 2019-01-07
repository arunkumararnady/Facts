package com.assignment.facts.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.assignment.facts.data.CountryData;
import com.assignment.facts.injection.AppComponent;
import com.assignment.facts.injection.Appmodule;
import com.assignment.facts.injection.DaggerAppComponent;
import com.assignment.facts.repository.Repository;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    @Inject
    public Repository repository;
    private LiveData<CountryData> countryData;

    public MainViewModel() {
        AppComponent appComponent = DaggerAppComponent
                .builder()
                .appmodule(new Appmodule())
                .build();
        appComponent.inject(this);
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
        countryData = repository.getData();
    }

}
