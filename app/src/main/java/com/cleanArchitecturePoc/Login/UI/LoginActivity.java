package com.cleanArchitecturePoc.Login.UI;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.Toast;


import com.cleanArchitecturePoc.CleanArchitectureApplication;
import com.cleanArchitecturePoc.Commons.RestClient;
import com.cleanArchitecturePoc.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;


public class LoginActivity extends AppCompatActivity{


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.submit)
    Button mLoginSubmit;

    @BindView(R.id.username)
    TextInputEditText mUserName;

    @BindView(R.id.password)
    TextInputEditText mPassword;

    @OnClick(R.id.submit)
    public void submitFunctionality(){

    }

    @Inject
    RestClient restClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ((CleanArchitectureApplication)getApplication()).getComponent().inject(this);
    }

}
