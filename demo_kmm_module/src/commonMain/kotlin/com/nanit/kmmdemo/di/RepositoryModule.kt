package com.nanit.kmmdemo.di

import com.nanit.kmmdemo.data.repository.testdata.TestDataRepository
import com.nanit.kmmdemo.data.repository.testdata.TestDataRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {

    factory<TestDataRepository> { TestDataRepositoryImpl(get(), get()) }

}