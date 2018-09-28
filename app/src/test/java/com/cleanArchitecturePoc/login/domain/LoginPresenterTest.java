package com.cleanArchitecturePoc.login.domain;

import com.cleanArchitecturePoc.login.ui.ILoginView;
import com.cleanArchitecturePoc.login.ui.LoginPresenter;
import com.cleanArchitecturePoc.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    private LoginPresenter presenter;
    @Mock
    private ILoginView view;
    @Mock
    private LoginService service;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(view, service);
    }

    @Test
    public void testShouldShowErrorMessageWhenUsernameIsEmpty() throws Exception {
        when(view.getUserName()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showUsernameError(R.string.username_error);

    }

    @Test
    public void testShouldShowErrorMessageWhenPasswordIsEmpty() throws Exception {
        when(view.getUserName()).thenReturn("nineleaps");
        when(view.getPassword()).thenReturn("");
        presenter.onLoginClicked();

        verify(view).showPasswordError(R.string.password_error);

    }

    @Test
    public void testShouldCheckActivitylaunch() throws Exception {
        when(view.getUserName()).thenReturn("nineleaps");
        when(view.getPassword()).thenReturn("nineleaps");
        when(service.login("nineleaps", "nineleaps")).thenReturn(true);
        presenter.onLoginClicked();

        verify(view).navigateDashboardActivity();

    }

    @Test
    public void testShowLoginErrorMessage() throws Exception {
        when(view.getUserName()).thenReturn("nineleaps");
        when(view.getPassword()).thenReturn("nineleaps");
        when(service.login("nineleaps", "nineleaps")).thenReturn(false);
        presenter.onLoginClicked();

        verify(view).showLoginErrorMessage();
    }

}