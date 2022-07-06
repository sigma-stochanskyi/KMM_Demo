package com.nanit.kmmdemo.android.app.di

import com.nanit.kmmdemo.android.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { MainViewModel(get(), get()) }

}