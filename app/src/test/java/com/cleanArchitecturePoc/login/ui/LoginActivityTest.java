package com.cleanArchitecturePoc.login.ui;

import android.support.design.widget.TextInputEditText;

import com.cleanArchitecturePoc.CleanArchitectureApplicationTest;
import com.cleanArchitecturePoc.MockAppModules;
import com.cleanArchitecturePoc.R;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(
        application = CleanArchitectureApplicationTest.class,
        packageName = "com.cleanArchitecturePoc",
        manifest = Config.NONE
)
public class LoginActivityTest {

    private LoginActivity mLoginActivityTest;
    //private TextInputEditText mUserNameEditext, mPasswordEditext;
    //private Button mLoginButton;

    @Before
    public void setUp() throws Exception {
        CleanArchitectureApplicationTest app = (CleanArchitectureApplicationTest) RuntimeEnvironment.application;
        MockAppModules modules = new MockAppModules(app);
        app.setApplicationModule(modules);
        mLoginActivityTest = Robolectric.buildActivity(LoginActivity.class).get();

    }


    @Test
    public void testNotNull() {
        Assert.assertNotNull(mLoginActivityTest);
        TextInputEditText username=(TextInputEditText)mLoginActivityTest.findViewById(R.id.username);
//        mPasswordEditext = (TextInputEditText) mLoginActivityTest.findViewById(R.id.password);
//        mLoginButton =(Button) mLoginActivityTest.findViewById(R.id.submit);

    }

    @Test
    public void testHintForEditText() {
       /* String usernameHint, passwordHint,loginButton;
        TextInputEditText mUserNameEditext= (TextInputEditText) mLoginActivityTest.findViewById(R.id.username);
        usernameHint = mUserNameEditext.getHint().toString();*/
//        passwordHint = mPasswordEditext.getHint().toString();
//        loginButton=mLoginButton.getText().toString();
//
//        Assert.assertNotNull(usernameHint);
//        Assert.assertNotNull(passwordHint);
//        Assert.assertNotNull(loginButton);
//        Assert.assertEquals("LOGIN",loginButton);
//        Assert.assertEquals("Username", usernameHint);
//        Assert.assertEquals("Password", passwordHint);

    }



    @After
    public void tearDown() throws Exception {
    }
}