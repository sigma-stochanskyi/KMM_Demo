package com.nanit.kmmdemo.di

import com.nanit.kmmdemo.TestDatabase
import com.nanit.kmmdemo.data.db.common.DatabaseDriverProvider
import com.nanit.kmmdemo.data.db.features.testdata.TestLocalDataSource
import com.nanit.kmmdemo.data.db.features.testdata.TestLocalDataSourceImpl
import org.koin.dsl.module

val databaseModule = module {

    single {
        val driverProvider: DatabaseDriverProvider = get()
        TestDatabase(driverProvider.provideDriver())
    }

    factory<TestLocalDataSource> { TestLocalDataSourceImpl(get()) }
}