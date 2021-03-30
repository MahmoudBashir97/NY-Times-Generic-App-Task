package com.mahmoudbashir.nytimesgenericapp.fragments

import androidx.navigation.NavController
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.MediumTest
import com.mahmoudbashir.nytimesgenericapp.R
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

@MediumTest
@ExperimentalCoroutinesApi
class HomeTimes_FragmentTest{

    @Before
    fun setup(){

    }
    @Test
    fun clickOnRecyclerItem(){
        val navController = Mockito.mock(NavController::class.java)
       // Navigation.setViewNavController(,navController)

        //Espresso.onView(ViewMatchers.withId(R.id.rec_times_articles)).perform()
    }

}