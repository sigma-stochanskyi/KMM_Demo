package com.nanit.kmmdemo.domain

import com.nanit.kmmdemo.data.repository.testdata.TestDataRepository
import com.nanit.kmmdemo.domain.models.TestData

class FetchTestDataUseCase(
    private val testDataRepository: TestDataRepository
) {
    suspend operator fun invoke(): TestData {
        return testDataRepository.fetchTestData()
    }
}