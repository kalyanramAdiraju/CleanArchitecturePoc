package com.cleanArchitecturePoc.login.ui;

import com.cleanArchitecturePoc.login.domain.LoginService;
import com.cleanArchitecturePoc.R;

import javax.inject.Inject;

public class LoginPresenter {

    private ILoginView view;
    private LoginService loginService;

    public LoginPresenter(ILoginView view,LoginService loginService) {
        this.view = view;
        this.loginService =loginService;
    }

    /**
     * On Login clicked
     */
    public void onLoginClicked() {
        String username = view.getUserName();
        String password = view.getPassword();
        if (username.isEmpty()) {
            view.showUsernameError(R.string.username_error);
            return;
        }
        if (password.isEmpty()) {
            view.showPasswordError(R.string.password_error);
            return;
        }
        boolean isLogin = loginService.login(username,password);
        if (isLogin){
            view.navigateDashboardActivity();
        }else {
            view.showLoginErrorMessage();
        }
    }
}
