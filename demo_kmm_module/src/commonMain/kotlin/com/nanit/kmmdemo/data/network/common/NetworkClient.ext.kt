package com.nanit.kmmdemo.data.network.common

import io.ktor.util.reflect.*

suspend inline fun <reified T> NetworkClient.get(url: String): T {
    return get(url, typeInfo<T>())
}