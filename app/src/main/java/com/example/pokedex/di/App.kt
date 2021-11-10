package com.example.pokedex.di

import android.app.Activity
import android.support.multidex.MultiDexApplication


open class App : MultiDexApplication() {

    open val Activity.app: App
        get() = application as App

    open val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }
}