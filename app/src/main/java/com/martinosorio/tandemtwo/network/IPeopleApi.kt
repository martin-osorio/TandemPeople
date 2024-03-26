package com.martinosorio.tandemtwo.network

import com.martinosorio.tandemtwo.model.Person

interface IPeopleApi {

    suspend fun getPeople() : List<Person>
}