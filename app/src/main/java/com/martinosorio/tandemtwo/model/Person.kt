package com.martinosorio.tandemtwo.model

import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("name")
    val name: String,

    @SerializedName("language")
    val language: String?,
)
