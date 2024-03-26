package com.martinosorio.tandemtwo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martinosorio.tandemtwo.model.Person
import com.martinosorio.tandemtwo.network.PeopleApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class PeopleScreenViewModel : ViewModel() {
    // TODO: Use DI

    val api = PeopleApi()

    val people : MutableStateFlow<List<Person>> = MutableStateFlow(listOf<Person>())

    init {
        getPeople()
    }

    fun getPeople() {
        viewModelScope.launch {
            people.tryEmit(api.getPeople())
        }
    }
}