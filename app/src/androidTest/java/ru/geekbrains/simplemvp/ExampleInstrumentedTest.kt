package ru.geekbrains.simplemvp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    private var mStringToBetyped: String? = null

    @get:Rule
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(
        MainActivity::class.java
    )

    @Before
    fun initValidString() {
        // Specify a valid string.
        mStringToBetyped = "Bob"
    }

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("ru.geekbrains.simplemvp", appContext.packageName)
    }

    @Test
    fun smoke_test() {
        onView(withId(R.id.editName))
            .perform(typeText(mStringToBetyped), closeSoftKeyboard())

        onView(withId(R.id.button)).perform(click())


        // Check that the text was changed.
        onView(withId(R.id.editName))
            .check(matches(withText(mStringToBetyped)))

        onView(withId(R.id.textHello))
            .check(matches(withText("Привет $mStringToBetyped")))
    }
}