package com.nanit.kmmdemo.data.db.common

import android.content.Context
import com.nanit.kmmdemo.TestDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverProvider(
    private val context: Context
) {
    actual fun provideDriver(): SqlDriver {
        return AndroidSqliteDriver(TestDatabase.Schema, context, "test_database.db")
    }
}