package com.nanit.kmmdemo.data.network.features.testdata

import com.nanit.kmmdemo.data.network.common.NetworkClient
import com.nanit.kmmdemo.data.network.common.get
import com.nanit.kmmdemo.data.network.features.testdata.response.TestResponse

class TestNetworkDataSource(
    private val networkClient: NetworkClient
) {

    suspend fun getTestResponse(): TestResponse =
        networkClient.get("https://jsonplaceholder.typicode.com/todos/1")

}