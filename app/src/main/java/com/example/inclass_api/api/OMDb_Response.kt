package com.example.inclass_api.api

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OMDb_Response(
    val photos: PhotoResponse
)
