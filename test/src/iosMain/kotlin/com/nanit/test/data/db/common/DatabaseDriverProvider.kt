package com.nanit.test.data.db.common

import com.nanit.kmmdemo.TestDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverProvider2 {
    actual fun provideDriver(): SqlDriver {
        return NativeSqliteDriver(TestDatabase2.Schema, "test_database.db")
    }
}