package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pokedex.feature.landing.view.LandingBottomSheet
import java.lang.reflect.Array.get

class MainActivity : AppCompatActivity() {

    val landingBottomSheet: LandingBottomSheet
        get() = LandingBottomSheet()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(checkFirstOpen()) landingBottomSheet.show(supportFragmentManager, "MainActivity")

    }


    private fun checkFirstOpen(): Boolean {
        return true
    }
}