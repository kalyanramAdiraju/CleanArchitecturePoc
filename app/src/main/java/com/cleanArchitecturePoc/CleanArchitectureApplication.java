package com.cleanArchitecturePoc;

import android.app.Application;

import com.cleanArchitecturePoc.commons.inject.AppComponent;
import com.cleanArchitecturePoc.commons.inject.AppModule;
import com.cleanArchitecturePoc.commons.inject.DaggerAppComponent;

import javax.inject.Singleton;

import dagger.Component;


public class CleanArchitectureApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
    }

    protected AppModule getAppModule() {
        return new AppModule(this);
    }

    public AppComponent getAppComponent() {
        return component;
    }

    public void initComponent() {
        component = DaggerAppComponent.builder()
                .appModule(getAppModule())
                .build();


    }
}