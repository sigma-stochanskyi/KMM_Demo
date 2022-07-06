package com.nanit.kmmdemo.android.app

import android.app.Application
import com.nanit.kmmdemo.android.app.di.presentationModule
import com.nanit.kmmdemo.di.commonModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class KmmDemoApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@KmmDemoApplication)
            modules(commonModules + presentationModule)
        }
    }
}