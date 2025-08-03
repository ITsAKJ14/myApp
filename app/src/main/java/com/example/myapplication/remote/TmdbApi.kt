package com.example.myapplication.remote

import com.example.myapplication.remote.models.RemoteMovieList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TmdbApi {
    @GET("movie/{category}")
    suspend fun getMovieInfo(
        @Path("category") category: String,
        @Query("api_key") apiKey: String
    ): Response<RemoteMovieList>

}