package com.martinosorio.tandemtwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.martinosorio.tandemtwo.ui.PeopleScreen
import com.martinosorio.tandemtwo.ui.theme.TandemTwoTheme

/*

ASSESSMENT INSTRUCTIONS:
    Parse the json from https://gist.github.com/russellbstephens/41e3b81879cf096212fc9834be0407b5 into models
    Display each person in a list
    Display each person's favorite language, or "Unknown" if not given

CANDIDATE OBSERVATIONS:
    I found that one of the problems I was having was with the endpoint. The given endpoint goes to a GitHub page,
    rather than to the date itself. I found that the "Raw" button in this page leads to the actual json endpoint, being:
    https://gist.githubusercontent.com/russellbstephens/41e3b81879cf096212fc9834be0407b5/raw/388971ddd9fd1b099e829de233526eb345a1ad37/people.json
    Using this endpoint instead I was able to obtain the data as expected.

    Besides this, there were a few minor changes made after the end of the interview, those being:
    1) Created PeopleResponse data class
    2) Improved data classes and added serialized names
    3) Manually created my Gson, Interceptor, and OkHttpClient objects for better debugging and logging
    4) Improved the UI by adding spacing, centering, and font size
    5) Added a empty/loading state to the UI
    6) Other cleanup and comments

 */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityContent()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityContent() {
    TandemTwoTheme {
        PeopleScreen(viewModel = PeopleScreenViewModel())
    }
}