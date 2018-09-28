package com.cleanArchitecturePoc.login.ui;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import com.cleanArchitecturePoc.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)

public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> mLoginActivityTestRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);


    @Before
    public void setUp() throws Exception {
    }

    /**
     * this function will test if the EditText is empty for not
     */

    @Test
    public void testNegativeFlowInputValidations() {
        String userName = InstrumentationRegistry.getTargetContext().getString(R.string.username);
        String password = InstrumentationRegistry.getTargetContext().getString(R.string.password);
        Espresso.onView(withId(R.id.username)).check(matches(hasTextInputLayoutHintText(userName)));

        Espresso.onView(withId(R.id.password)).check(matches(hasTextInputLayoutHintText(password)));

        Espresso.onView(withId(R.id.username)).perform(typeText(""));

        Espresso.onView(withId(R.id.username)).check(matches(withText("")));

        Espresso.onView(withId(R.id.password)).perform(typeText(""));

        Espresso.onView(withId(R.id.password)).check(matches(withText("")));

        Espresso.onView(withId(R.id.submit)).perform(click());

    }

    @Test
    public void testErrorMessagesForEditText() {
        String usernameDummy = InstrumentationRegistry.getTargetContext().getString(R.string.username_dummy);
        String usernameError = InstrumentationRegistry.getTargetContext().getString(R.string.username_error);
        String passwordError = InstrumentationRegistry.getTargetContext().getString(R.string.password_error);


        Espresso.onView(withId(R.id.submit)).perform(click());
        Espresso.onView(withId(R.id.username_layout)).check(matches(hasTextInputLayoutErrorText(usernameError)));
        Espresso.onView(withId(R.id.username)).perform(typeText(usernameDummy));
        Espresso.onView(withId(R.id.submit)).perform(click());
        Espresso.onView(withId(R.id.password_layout)).check(matches(hasTextInputLayoutErrorText(passwordError)));
    }

    /**
     * This function will test if the
     */

    @Test
    public void testInputValidations() {
        String usernameDummy = InstrumentationRegistry.getTargetContext().getString(R.string.username_dummy);
        String passwordDummy = InstrumentationRegistry.getTargetContext().getString(R.string.password_dummy);
        Espresso.onView(withId(R.id.username)).perform(typeText(usernameDummy));

        Espresso.onView(withId(R.id.username)).check(matches(withText(usernameDummy)));

        Espresso.onView(withId(R.id.password)).perform(typeText(passwordDummy));

        Espresso.onView(withId(R.id.password)).check(matches(withText(passwordDummy)));

        Espresso.onView(withId(R.id.submit)).perform(click());
    }

    public static Matcher<View> hasTextInputLayoutHintText(final String expectedErrorText) {
        return new TypeSafeMatcher<View>() {

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof TextInputEditText)) {
                    return false;
                }

                CharSequence error = ((TextInputEditText) view).getHint();

                if (error == null) {
                    return false;
                }

                String hint = error.toString();

                return expectedErrorText.equals(hint);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }

    public static Matcher<View> hasTextInputLayoutErrorText(final String expectedErrorText) {
        return new TypeSafeMatcher<View>() {

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof TextInputLayout)) {
                    return false;
                }

                CharSequence error = ((TextInputLayout) view).getError();

                if (error == null) {
                    return false;
                }

                String hint = error.toString();

                return expectedErrorText.equals(hint);
            }

            @Override
            public void describeTo(Description description) {
            }
        };
    }


}