package com.nanit.kmmdemo.di

val commonModules = listOf(
    databaseModule,
    databasePlatformModule(),
    networkModule,
    repositoryModule,
    domainModule,
)