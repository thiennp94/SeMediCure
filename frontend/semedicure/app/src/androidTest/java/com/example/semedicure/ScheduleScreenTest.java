package com.example.semedicure;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.test.espresso.contrib.PickerActions;
import androidx.test.filters.LargeTest;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class ScheduleScreenTest {
    @Rule
    public ActivityTestRule<ScheduleApptActivity> scheduleActivity = new ActivityTestRule<>(ScheduleApptActivity.class);

    @Test
    public void testScheduleScreen() {
        onView(withId(R.id.button8)).perform(click());
        onView(withClassName(Matchers.equalTo(TimePicker.class.getName()))).perform(PickerActions.setTime(5, 15));
        onView(withText("OK")).perform(click());
        onView(withId(R.id.button8)).check(matches(withText("05:15")));
        onView(withId(R.id.button9)).perform(click());
        onView(withText("Yes")).perform(click());
        onView(withId(R.id.textView)).check(matches(isDisplayed()));
    }

}