package com.assignment.facts;

import android.app.Application;

import com.assignment.facts.injection.AppComponent;
import com.assignment.facts.injection.AppModule;
import com.assignment.facts.injection.DaggerAppComponent;

public class FactsApp extends Application {

    private AppComponent mAppComponent;
    private static FactsApp app;

    public static FactsApp getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mAppComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {
       return mAppComponent;
    }
}