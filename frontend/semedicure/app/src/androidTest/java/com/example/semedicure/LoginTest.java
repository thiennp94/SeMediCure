package com.example.semedicure;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class LoginTest {

    private static final int SIMULATED_DELAY_MS = 500;

     @Rule
     public ActivityTestRule<LoginActivity> mainActivity = new ActivityTestRule<>(LoginActivity.class);

     @Test
     public void testLoginAdmin() {
         String user = "emily@email.com";
         String password = "ThisBl0w$";
         String selectionText = "Administrator";
         onView(withId(R.id.editTextTextPersonName)).perform(typeText(user), closeSoftKeyboard()); // username
         onView(withId(R.id.editTextTextPersonName2)).perform(typeText(password), closeSoftKeyboard()); // password
         onView(withId(R.id.spinner)).perform(click());
         onData(allOf(is(instanceOf(String.class)), is(selectionText))).perform(click());
         onView(withId(R.id.button2)).perform(click()); // click login

         // Put thread to sleep to allow volley to handle the request
         try {
             Thread.sleep(SIMULATED_DELAY_MS);
         } catch (InterruptedException e) {
         }

         onView(withId(R.id.button6)).check(matches(isDisplayed())); // view/update profile on admin screen
     }

    @Test
    public void testLoginPatient() {
        String user = "mbyrde@email.com";
        String password = "ThisBl0w$";
        String selectionText = "Patient";
        onView(withId(R.id.editTextTextPersonName)).perform(typeText(user), closeSoftKeyboard()); // username
        onView(withId(R.id.editTextTextPersonName2)).perform(typeText(password), closeSoftKeyboard()); // password
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(selectionText))).perform(click());
        onView(withId(R.id.button2)).perform(click()); // click login

        // Put thread to sleep to allow volley to handle the request
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }

        onView(withId(R.id.button6)).check(matches(isDisplayed())); // update medical history on patient screen
    }

    @Test
    public void testLoginProvider() {
        String user = "mscott@email.com";
        String password = "ThisBl0w$";
        String selectionText = "Doctor";
        onView(withId(R.id.editTextTextPersonName)).perform(typeText(user), closeSoftKeyboard()); // username
        onView(withId(R.id.editTextTextPersonName2)).perform(typeText(password), closeSoftKeyboard()); // password
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(selectionText))).perform(click());
        onView(withId(R.id.button2)).perform(click()); // click login

        // Put thread to sleep to allow volley to handle the request
        try {
            Thread.sleep(SIMULATED_DELAY_MS);
        } catch (InterruptedException e) {
        }

        onView(withId(R.id.button6)).check(matches(isDisplayed())); // view/update profile on provider screen
    }

     @Test
    public void testLoginFailedWrongPass() {
        String user = "emily@email.com";
        String password = "Thi$"; // wrong password
        String selectionText = "Administrator";
        onView(withId(R.id.editTextTextPersonName)).perform(typeText(user), closeSoftKeyboard()); // username
        onView(withId(R.id.editTextTextPersonName2)).perform(typeText(password), closeSoftKeyboard()); // password
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(selectionText))).perform(click());
        onView(withId(R.id.button2)).perform(click()); // click login
        onView(withId(R.id.editTextTextPersonName2)).check(matches(isDisplayed())); // still in login screen
    }

    @Test
    public void testLoginFailedWrongUser() {
        String user = "emily@";
        String password = "ThisBl0w$"; // wrong password
        String selectionText = "Administrator";
        onView(withId(R.id.editTextTextPersonName)).perform(typeText(user), closeSoftKeyboard()); // username
        onView(withId(R.id.editTextTextPersonName2)).perform(typeText(password), closeSoftKeyboard()); // password
        onView(withId(R.id.spinner)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is(selectionText))).perform(click());
        onView(withId(R.id.button2)).perform(click()); // click login
        onView(withId(R.id.editTextTextPersonName2)).check(matches(isDisplayed())); // still in login screen
    }

}
