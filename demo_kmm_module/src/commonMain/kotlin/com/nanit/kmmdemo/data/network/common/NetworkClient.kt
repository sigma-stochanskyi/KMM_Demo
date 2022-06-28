package com.nanit.kmmdemo.data.network.common

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.reflect.*

interface NetworkClient {

    suspend fun <T> get(url: String, typeInfo: TypeInfo): T

    // TODO some more network operations like post, put etc.
}

class NetworkClientImpl : NetworkClient {
    private val client by lazy {
        HttpClient() {
            install(ContentNegotiation) {
                json()
            }
        }
    }

    override suspend fun <T> get(url: String, typeInfo: TypeInfo): T {
        return client.get(url).body(typeInfo)
    }
}