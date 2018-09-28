package com.cleanArchitecturePoc.login.ui;

public interface ILoginView {


    String getUserName();

    void showUsernameError(int usernameError);

    String getPassword();

    void showPasswordError(int passwordError);

    void navigateDashboardActivity();

    void showLoginErrorMessage();
}
