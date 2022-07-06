package com.nanit.test.data.db.features.testdata

import com.nanit.kmmdemo.TestDatabase2
import com.nanit.kmmdemo.db.TestDataEntity2

interface TestLocalDataSource2 {
    fun getFirstData(): TestDataEntity2?
    fun getAllData(): List<TestDataEntity2>

    fun insertData(testData: TestDataEntity2)

    fun clearData()
}

internal class TestLocalDataSourceImpl2(
    private val database: TestDatabase2
): TestLocalDataSource2 {

    override fun getFirstData(): TestDataEntity2? {
        return database.testDatabase2Queries.getTestData().executeAsOneOrNull()
    }

    override fun getAllData(): List<TestDataEntity2> {
        return database.testDatabase2Queries.getTestData().executeAsList()
    }

    override fun insertData(testData: TestDataEntity2) {
        database.testDatabase2Queries.insertTestData(
            userId = testData.userId,
            id = testData.id,
            title = testData.title,
            completed = testData.completed,
        )
    }

    override fun clearData() {
        database.testDatabase2Queries.clearTestData()
    }
}