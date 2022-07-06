package com.nanit.kmmdemo.data.repository.testdata

import com.nanit.kmmdemo.data.db.features.testdata.TestLocalDataSource
import com.nanit.kmmdemo.data.network.features.testdata.TestNetworkDataSource
import com.nanit.kmmdemo.data.network.features.testdata.response.TestResponse
import com.nanit.kmmdemo.db.TestDataEntity
import com.nanit.kmmdemo.domain.models.TestData
import com.nanit.kmmdemo.utils.successOnFailure

interface TestDataRepository {
    suspend fun fetchTestData(): TestData

}

class TestDataRepositoryImpl(
    private val testNetworkDataSource: TestNetworkDataSource,
    private val testLocalDataSource: TestLocalDataSource,
) : TestDataRepository {

    override suspend fun fetchTestData(): TestData {
        return runCatching {
            loadRemoteData()
        }.successOnFailure {
            loadLocalData() ?: throw it
        }.getOrThrow()
    }

    private suspend fun loadRemoteData(): TestData {
        return testNetworkDataSource.getTestResponse()
            .also { saveToLocalData(it) }
            .parse()
    }

    private fun loadLocalData(): TestData? {
        return testLocalDataSource.getFirstData()?.parse()
    }

    private fun saveToLocalData(response: TestResponse) {
        testLocalDataSource.insertData(response.toEntity())
    }

    private fun TestResponse.parse(): TestData {
        return TestData(title)
    }

    private fun TestDataEntity.parse(): TestData {
        return TestData(title ?: "")
    }

    private fun TestResponse.toEntity(): TestDataEntity {
        return TestDataEntity(
            userId = userId.toLong(),
            id = id.toLong(),
            title = title,
            completed = completed,
        )
    }
}