package com.nanit.kmmdemo.di

import com.nanit.kmmdemo.data.db.common.DatabaseDriverProvider
import org.koin.dsl.module

actual fun databasePlatformModule() = module {

    factory { DatabaseDriverProvider(get()) }

}