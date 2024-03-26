package com.martinosorio.tandemtwo

import com.martinosorio.tandemtwo.model.Person
import retrofit2.http.GET

interface PeopleCalls {

    @GET("41e3b81879cf096212fc9834be0407b5")
    suspend fun getPeople(): List<Person>
}