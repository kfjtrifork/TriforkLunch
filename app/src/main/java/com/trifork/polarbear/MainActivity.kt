package com.trifork.polarbear

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trifork.polarbear.ui.theme.TriLunchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriLunchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun Week (weekNumber: Int) {
    val columnCount = 6
    val rowCount = 3
    Column {
        Text(text = "Week $weekNumber")
        for (ColumnIndex in 1..columnCount) {
            Row {
                for (rowIndex in 1..rowCount) {
                    Column(modifier = Modifier.padding(10.dp)) {
                        Text("test")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TriLunchTheme {
        Greeting("Android")
    }
}
@Preview(showBackground = true)
@Composable
fun WeekPreview() {
    TriLunchTheme {
        Week(42)
    }
}