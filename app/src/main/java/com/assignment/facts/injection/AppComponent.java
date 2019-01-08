package com.assignment.facts.injection;

import com.assignment.facts.repository.CountryService;
import com.assignment.facts.viewmodel.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(MainViewModel model);
    void inject(CountryService service);
}
