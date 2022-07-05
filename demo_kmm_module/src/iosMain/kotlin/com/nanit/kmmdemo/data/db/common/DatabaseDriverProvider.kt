package com.nanit.kmmdemo.data.db.common

import com.nanit.kmmdemo.TestDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverProvider {
    actual fun provideDriver(): SqlDriver {
        return NativeSqliteDriver(TestDatabase.Schema, "test_database.db")
    }
}