package com.nanit.kmmdemo.di

import com.nanit.kmmdemo.domain.FetchTestDataUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { FetchTestDataUseCase(get()) }

}