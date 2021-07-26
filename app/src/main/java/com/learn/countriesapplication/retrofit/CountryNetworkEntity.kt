package com.learn.countriesapplication.retrofit

import com.google.gson.annotations.SerializedName

class CountryNetworkEntity(

    @SerializedName("name")
    var name: String,

    @SerializedName("capital")
    var capital: String,

    @SerializedName("flag")
    var flag: String,

    @SerializedName("region")
    var region: String,

    @SerializedName("population")
    var population: Long,

    @SerializedName("area")
    var area: Long
)
