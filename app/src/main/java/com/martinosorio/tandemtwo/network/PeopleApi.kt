package com.martinosorio.tandemtwo.network

import com.martinosorio.tandemtwo.model.Person
import retrofit2.Retrofit

class PeopleApi : IPeopleApi {
    override suspend fun getPeople(): List<Person> {
        return RetrofitApi.service.getPeople()
    }
}