package com.cleanArchitecturePoc.commons.inject;

import com.cleanArchitecturePoc.login.ui.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    LoginActivity inject(LoginActivity mLoginActivity);
}
