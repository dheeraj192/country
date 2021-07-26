package com.learn.countriesapplication.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface CountryRetrofit {
    companion object {
        val API_URL: String = "https://restcountries.eu/rest/v2/"
    }

    @GET("region/{region}")
    suspend fun get(@Path("region") region: String): List<CountryNetworkEntity>
}