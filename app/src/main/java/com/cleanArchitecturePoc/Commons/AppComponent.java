package com.cleanArchitecturePoc.Commons;

import com.cleanArchitecturePoc.Login.UI.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    LoginActivity inject(LoginActivity mLoginActivity);
}
