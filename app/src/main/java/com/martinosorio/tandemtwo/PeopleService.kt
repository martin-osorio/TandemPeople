package com.martinosorio.tandemtwo

import com.martinosorio.tandemtwo.model.PeopleResponse
import retrofit2.Response
import retrofit2.http.GET

interface PeopleService {

    @GET("41e3b81879cf096212fc9834be0407b5")
    suspend fun getPeople(): Response<PeopleResponse>
}