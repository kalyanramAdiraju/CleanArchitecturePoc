package com.cleanArchitecturePoc.Login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.TextView;

import com.cleanArchitecturePoc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity{


    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.submit)
    Button mLoginSubmit;

    @BindView(R.id.username)
    TextView mUserName;

    @BindView(R.id.password)
    TextView mPassword;

    @OnClick(R.id.submit)
    private void submitFunctionality(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

    }

}
