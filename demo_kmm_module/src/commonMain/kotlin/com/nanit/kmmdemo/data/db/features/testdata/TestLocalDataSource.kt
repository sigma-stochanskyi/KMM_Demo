package com.nanit.kmmdemo.data.db.features.testdata

import com.nanit.kmmdemo.TestDatabase
import com.nanit.kmmdemo.db.TestDataEntity

interface TestLocalDataSource {
    fun getFirstData(): TestDataEntity?
    fun getAllData(): List<TestDataEntity>

    fun insertData(testData: TestDataEntity)

    fun clearData()
}

internal class TestLocalDataSourceImpl(
    private val database: TestDatabase
): TestLocalDataSource {

    override fun getFirstData(): TestDataEntity? {
        return database.testDatabaseQueries.getTestData().executeAsOneOrNull()
    }

    override fun getAllData(): List<TestDataEntity> {
        return database.testDatabaseQueries.getTestData().executeAsList()
    }

    override fun insertData(testData: TestDataEntity) {
        database.testDatabaseQueries.insertTestData(
            userId = testData.userId,
            id = testData.id,
            title = testData.title,
            completed = testData.completed,
        )
    }

    override fun clearData() {
        database.testDatabaseQueries.clearTestData()
    }
}