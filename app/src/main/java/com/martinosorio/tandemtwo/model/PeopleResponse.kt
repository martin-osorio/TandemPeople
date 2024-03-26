package com.martinosorio.tandemtwo.model

import com.google.gson.annotations.SerializedName

data class PeopleResponse(
    @SerializedName("people")
    val people: List<Person>,
)
