package com.martinosorio.tandemtwo.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.martinosorio.tandemtwo.Greeting
import com.martinosorio.tandemtwo.PeopleScreenViewModel
import kotlinx.coroutines.flow.collect

@Composable
fun PeopleScreen(viewModel: PeopleScreenViewModel) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        val people = viewModel.people.collectAsState(initial = listOf()).value //todo

        LazyColumn(){
            people.forEach {
                item {
                    Text(text = it.name)
                    Text(text = it.language ?: "Unknown")
                }
            }
        }
    }
}