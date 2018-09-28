package com.cleanArchitecturePoc.commons.inject;

import com.cleanArchitecturePoc.CleanArchitectureApplication;
import com.cleanArchitecturePoc.CleanArchitectureApplicationTest;
import com.cleanArchitecturePoc.commons.RestClient;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.robolectric.RuntimeEnvironment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModuleTest {

    private CleanArchitectureApplicationTest applicationTest;

    private AppModule appModule;

    public AppModuleTest(CleanArchitectureApplicationTest application) {
        this.applicationTest = application;
    }


    @Before
    public void setUp() {
        CleanArchitectureApplicationTest app = (CleanArchitectureApplicationTest) RuntimeEnvironment.application;
        appModule = new AppModule(app);
    }

    @Test
    public void testAppModuleApp() {
        // App
        CleanArchitectureApplication app = (CleanArchitectureApplication) appModule.provideCleanArchitecture();
        Assert.assertNotNull(app);
        Assert.assertTrue(app instanceof CleanArchitectureApplication);
    }


    @Provides
    @Singleton
    public RestClient provideRetrofit() {
        return Mockito.mock(RestClient.class);
    }

}