package com.nanit.kmmdemo.data.db.common

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverProvider {
    fun provideDriver(): SqlDriver
}