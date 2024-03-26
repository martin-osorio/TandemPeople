package com.martinosorio.tandemtwo.network

import com.google.gson.GsonBuilder
import com.martinosorio.tandemtwo.PeopleService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var baseUrl = "https://gist.github.com/russellbstephens/"

    private var gson = GsonBuilder()
        .setLenient()
        .create()

    private var retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    var service: PeopleService = retrofit.create(PeopleService::class.java)
}