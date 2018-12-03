package io.github.anandpc.moviesfeed;

import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest
{
    private MainActivity activity;
    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() throws Exception
    {
        activity = activityActivityTestRule.getActivity();
    }

    @After
    public void tearDown() throws Exception
    {
        activity = null;
    }

    @Test
    public void checkNetwork()
    {
        boolean isNetwork = activity.checkNetwork();
        assertTrue(isNetwork);
    }
}