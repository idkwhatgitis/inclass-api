package com.example.inclass_api.api

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.Call

private const val API_KEY = "yourApiKeyHere"

//http://www.omdbapi.com/?i=tt3896198&apikey=8149c463

//http://img.omdbapi.com/?apikey=[yourkey]&

interface OMDb_API {
        @GET("/")
        fun getMovie(
            @Query("t") name: String,
            @Query("apikey") apiKey: String
        ): Call<movieItem>
    }