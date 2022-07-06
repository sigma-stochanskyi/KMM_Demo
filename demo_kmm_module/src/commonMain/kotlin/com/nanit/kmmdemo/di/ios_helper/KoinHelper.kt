package com.nanit.kmmdemo.di.ios_helper

import com.nanit.kmmdemo.di.commonModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(commonModules)
    }
}