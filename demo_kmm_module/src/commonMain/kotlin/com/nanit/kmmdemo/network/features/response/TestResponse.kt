package com.nanit.kmmdemo.network.features.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class TestResponse(
    @SerialName("userId")
    val userId: Int,
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("completed")
    val completed: Boolean,
)