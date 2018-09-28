package com.cleanArchitecturePoc.login.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.cleanArchitecturePoc.CleanArchitectureApplication;
import com.cleanArchitecturePoc.login.domain.LoginService;
import com.cleanArchitecturePoc.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity implements ILoginView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.submit)
    Button mLoginSubmit;

    @BindView(R.id.username_layout)
    TextInputLayout mUserNameLayout;

    @BindView(R.id.username)
    TextInputEditText mUsernameEditText;

    @BindView(R.id.password)
    TextInputEditText mPasswordEditText;

    @BindView(R.id.password_layout)
    TextInputLayout mPasswordLayout;

    @Inject
    LoginPresenter presenter;

    @Inject
    LoginService loginService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ((CleanArchitectureApplication) getApplication()).getAppComponent().inject(this);
        presenter = new LoginPresenter(this,loginService);
    }

    public void onLoginClicked(View view) {
        presenter.onLoginClicked();
    }

    @Override
    public String getUserName() {

        return String.valueOf(mUsernameEditText.getText());
    }

    @Override
    public void showUsernameError(int usernameError) {
        mUserNameLayout.setError(getString(usernameError));
    }

    @Override
    public String getPassword() {
        return String.valueOf(mPasswordEditText.getText());
    }

    @Override
    public void showPasswordError(int passwordError) {
    mPasswordLayout.setError(getString(passwordError));
    }

    @Override
    public void navigateDashboardActivity() {
        Intent intent =new Intent(LoginActivity.this,LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void showLoginErrorMessage() {
        Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
    }


}
