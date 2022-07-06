package com.nanit.kmmdemo.di.ios_helper

import com.nanit.kmmdemo.domain.FetchTestDataUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class Injector : KoinComponent {
    private val fetchTestDataUseCase: FetchTestDataUseCase by inject()
    fun fetchTestDataUseCase() = fetchTestDataUseCase
}