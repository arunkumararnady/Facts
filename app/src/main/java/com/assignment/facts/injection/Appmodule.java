package com.assignment.facts.injection;

import com.assignment.facts.repository.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class Appmodule {

    public Appmodule() {
    }

    @Provides
    @Singleton
    Repository provideRepository(){
        return new Repository();
    }

}
