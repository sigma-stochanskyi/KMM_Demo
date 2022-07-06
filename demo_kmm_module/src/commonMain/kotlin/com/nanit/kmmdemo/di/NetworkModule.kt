package com.nanit.kmmdemo.di

import com.nanit.kmmdemo.data.network.common.NetworkClient
import com.nanit.kmmdemo.data.network.common.NetworkClientImpl
import com.nanit.kmmdemo.data.network.features.testdata.TestNetworkDataSource
import org.koin.dsl.module

val networkModule = module {

    single<NetworkClient> { NetworkClientImpl() }

    factory { TestNetworkDataSource(get()) }

}