package com.cleanArchitecturePoc;


import com.cleanArchitecturePoc.commons.inject.AppModule;


public class CleanArchitectureApplicationTest extends CleanArchitectureApplication {

    private AppModule mAppModule;

    @Override
    protected AppModule getAppModule() {
        if (null == mAppModule) {
            return super.getAppModule();
        }
        return mAppModule;
    }

    public void setApplicationModule(AppModule appModule) {
        this.mAppModule = appModule;
        initComponent();
    }
}