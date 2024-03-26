package com.martinosorio.tandemtwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.martinosorio.tandemtwo.ui.PeopleScreen
import com.martinosorio.tandemtwo.ui.theme.TandemTwoTheme

/*
Parse the json from https://gist.github.com/russellbstephens/41e3b81879cf096212fc9834be0407b5 into models
Display each person in a list
Display each person's favorite language, or "Unknown" if not given
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TandemTwoTheme {
                PeopleScreen(viewModel = PeopleScreenViewModel())   // TODO: DI
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TandemTwoTheme {
        Greeting("Android")
    }
}