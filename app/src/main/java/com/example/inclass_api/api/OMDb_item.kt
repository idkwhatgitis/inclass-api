package com.example.inclass_api.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OMDb_item(
    val title: String,
    val id: String,
    @Json(name = "url_s") val url: String,
)
