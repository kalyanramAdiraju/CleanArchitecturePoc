package com.cleanArchitecturePoc;

import android.app.Application;

import com.cleanArchitecturePoc.Commons.AppComponent;
import com.cleanArchitecturePoc.Commons.AppModule;
import com.cleanArchitecturePoc.Commons.DaggerAppComponent;


public class CleanArchitectureApplication extends Application {

private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initComponent();
    }

    public void initComponent() {
    component= DaggerAppComponent.builder().
            appModule(getAppModule()).build();
    }

    public AppComponent getComponent() {
        return component;
    }

    public AppModule getAppModule() {
        return new AppModule(this);
    }
}
