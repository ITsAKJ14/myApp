package com.example.myapplication.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "4c4747195d66c02d2d5bc29a2aa8042b"
const val CATEGORY_POPULAR = "popular"
const val CATEGORY_UPCOMING = "upcoming"

object TmdbApiImp {


    fun getInstance(): TmdbApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TmdbApi::class.java)
    }

}