package com.martinosorio.tandemtwo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.martinosorio.tandemtwo.PeopleScreenViewModel

@Composable
fun PeopleScreen(viewModel: PeopleScreenViewModel) {
    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        val people = viewModel.peopleStateFlow.collectAsState(initial = listOf()).value

        // If the list of people is empty, show a loading screen
        if (people.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    item {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(all = 50.dp),
                            textAlign = TextAlign.Center,
                            fontSize = 30.sp,
                            text = "PEOPLE"
                        )
                    }

                    people.forEach {
                        item {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp, top = 10.dp, bottom = 5.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                text = it.name
                            )

                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 30.dp),
                                textAlign = TextAlign.Center,
                                fontSize = 20.sp,
                                text = it.language ?: "Unknown"
                            )
                        }
                    }
                }
            }
        }
    }
}