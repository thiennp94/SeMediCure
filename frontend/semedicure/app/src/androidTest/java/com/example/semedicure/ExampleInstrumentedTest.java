package com.example.semedicure;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Context;

import androidx.annotation.ContentView;
import androidx.test.espresso.ViewAction;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class ExampleInstrumentedTest {
    @Rule
    public ActivityTestRule<LoginActivity> loginActivity = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testLoginScreen() {
        onView(withId(R.id.editTextTextPersonName)).perform(typeText("patient1"));
        onView(withId(R.id.editTextTextPersonName2)).perform(typeText("patient1"));
        onView(withId(R.id.button2)).perform(click());
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
    }

}