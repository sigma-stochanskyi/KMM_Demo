package com.nanit.test.data.db.common

import android.content.Context
import com.nanit.kmmdemo.TestDatabase2
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverProvider2(
    private val context: Context
) {
    actual fun provideDriver(): SqlDriver {
        return AndroidSqliteDriver(TestDatabase2.Schema, context, "test_database.db")
    }
}