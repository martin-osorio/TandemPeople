package com.martinosorio.tandemtwo

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martinosorio.tandemtwo.model.Person
import com.martinosorio.tandemtwo.network.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PeopleScreenViewModel : ViewModel() {
    private val peopleService = RetrofitClient.service

    val people : MutableStateFlow<List<Person>> = MutableStateFlow(listOf())

    init {
        getPeople()
    }

    private fun getPeople() {
        viewModelScope.launch {
            try {
                val result = peopleService.getPeople()

                if (result.isSuccessful && result.body() != null) {
                    val peopleResult = result.body()!!.people
                    people.tryEmit(peopleResult)
                } else {
                    // TODO: emit error state
                    Log.d("moltag", "getPeople: error state response from peopleService")
                }
            } catch (e: Exception) {
                Log.d("moltag", "getPeople: caught error: $e")
            }
        }
    }
}