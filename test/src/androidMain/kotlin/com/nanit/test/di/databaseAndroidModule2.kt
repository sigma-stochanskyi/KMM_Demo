package com.nanit.test.di

import com.nanit.test.data.db.common.DatabaseDriverProvider2
import org.koin.dsl.module

actual fun databasePlatformModule2() = module {

    factory { DatabaseDriverProvider2(get()) }

}