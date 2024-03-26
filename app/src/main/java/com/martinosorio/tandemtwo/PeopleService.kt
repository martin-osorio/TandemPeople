package com.martinosorio.tandemtwo

import com.martinosorio.tandemtwo.model.PeopleResponse
import retrofit2.Response
import retrofit2.http.GET

interface PeopleService {

    @GET("41e3b81879cf096212fc9834be0407b5/raw/388971ddd9fd1b099e829de233526eb345a1ad37/people.json")
    suspend fun getPeople(): Response<PeopleResponse>
}