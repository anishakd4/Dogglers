package com.anishdubey.dogglers

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.scrollToPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.anishdubey.dogglers.BaseTest.DrawableMatcher.hasItemCount
import com.anishdubey.dogglers.ui.Dogglers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class HorizontalListTests : BaseTest() {

    @get:Rule
    var activityRule: ActivityScenarioRule<Dogglers>
            = ActivityScenarioRule(Dogglers::class.java)

    @Test
    fun `horizontal_scroll_content_at_first_position`() {
        checkFirstPosition()
    }

    @Test
    fun `horizontal_scroll_content_at_last_position`() {
        onView(withId(R.id.recycler_view))
            .perform(scrollToPosition<RecyclerView.ViewHolder>(lastPosition))
        onView(withText("Bella")).check(matches(isDisplayed()))
    }

    @Test
    fun `horizontal_scrolling`() {
        onView(withId(R.id.recycler_view))
            .perform(swipeLeft())
        onView(withText("Frankie")).check(matches(isDisplayed()))
    }

    @Test
    fun `recycler_view_item_count`() {
        onView(withId(R.id.recycler_view)).check(hasItemCount(6))
    }
}