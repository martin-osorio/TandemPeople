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
    val peopleStateFlow: MutableStateFlow<List<Person>> = MutableStateFlow(listOf())

    init {
        getPeople()
    }

    private fun getPeople() {
        viewModelScope.launch {
            try {
                val result = peopleService.getPeople()

                if (result.isSuccessful && result.body() != null) {
                    peopleStateFlow.tryEmit(result.body()!!.people)
                } else {
                    // If there is any issue, just log error. Improve this by using a UiState object with Loading, Error, and Success states
                    Log.d("moltag", "getPeople: error state response from peopleService")
                }
            } catch (e: Exception) {
                Log.d("moltag", "getPeople: caught exception: $e")
            }
        }
    }
}