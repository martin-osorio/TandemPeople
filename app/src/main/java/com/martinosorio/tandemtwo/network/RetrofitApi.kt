package com.martinosorio.tandemtwo.network

import com.martinosorio.tandemtwo.PeopleCalls
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitApi {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://gist.github.com/russellbstephens/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    var service: PeopleCalls = retrofit.create(PeopleCalls::class.java)
}