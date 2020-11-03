package com.example.karmantestboock

import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface API {

    @GET("covers/")
    fun getCovers(): Call<List<Cover>>

    companion object {
        val api by lazy { retrofit.create(API::class.java)}
    }

}

private const val API_BASE_URL = "https://pivl.github.io/sample_api/"

val retrofit by lazy {
    val gson = GsonBuilder()
        .setLenient()
        .create()

    Retrofit.Builder()
        .baseUrl(API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}