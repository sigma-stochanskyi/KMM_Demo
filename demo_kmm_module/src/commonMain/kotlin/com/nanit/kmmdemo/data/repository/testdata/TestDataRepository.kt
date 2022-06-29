package com.nanit.kmmdemo.data.repository.testdata

import com.nanit.kmmdemo.data.network.features.testdata.TestNetworkDataSource
import com.nanit.kmmdemo.data.network.features.testdata.response.TestResponse
import com.nanit.kmmdemo.domain.models.TestData

interface TestDataRepository {
    suspend fun fetchTestData(): TestData

}

class TestDataRepositoryImpl(
    private val testNetworkDataSource: TestNetworkDataSource
) : TestDataRepository {

    override suspend fun fetchTestData(): TestData {
        return testNetworkDataSource.getTestResponse().parse()
    }

    private fun TestResponse.parse(): TestData {
        return TestData(title)
    }
}