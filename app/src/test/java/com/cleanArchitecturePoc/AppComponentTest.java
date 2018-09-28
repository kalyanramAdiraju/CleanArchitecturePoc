package com.cleanArchitecturePoc;

import com.cleanArchitecturePoc.commons.inject.AppComponent;
import com.cleanArchitecturePoc.commons.inject.AppModuleTest;
import com.cleanArchitecturePoc.login.ui.LoginActivityTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModuleTest.class)
public interface AppComponentTest extends AppComponent {
    void inject(LoginActivityTest mLoginActiviytest);
}
