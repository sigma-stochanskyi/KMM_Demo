package com.nanit.kmmdemo.network.features

import com.nanit.kmmdemo.network.common.NetworkClient
import com.nanit.kmmdemo.network.common.get
import com.nanit.kmmdemo.network.features.response.TestResponse

class TestNetworkDataSource(
    private val networkClient: NetworkClient
) {

    suspend fun getTestResponse(): TestResponse =
        networkClient.get("https://jsonplaceholder.typicode.com/todos/1")

}