package com.nanit.test.data.db.common

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverProvider2 {
    fun provideDriver(): SqlDriver
}