@file:OptIn(ExperimentalMaterial3Api::class)

package com.trifork.polarbear

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.trifork.polarbear.model.DayEnum
import com.trifork.polarbear.model.LocationEnum
import com.trifork.polarbear.ui.theme.TriLunchTheme
import androidx.lifecycle.viewmodel.compose.viewModel

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Week(viewModel: WeekViewModel = viewModel()) {

    // TODO. Observe
    val weeks by viewModel.weeksState.collectAsState()
    val weekNumber by viewModel.weekNumberState.collectAsState()

    val rowCount = 5

    Column(modifier = Modifier.width(500.dp)) {
        Text(text = "Week $weekNumber")
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(modifier = Modifier.width(100.dp)) {
                Text(text = "Day")
            }
            //LocationEnum.values().forEach {
                Column(modifier = Modifier.width(100.dp)) {
                    Text(text = "Localization")
                }
            //}
        }
        for (columnIndex in 1..rowCount) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Row(modifier = Modifier.width(100.dp)) {
                        Text(text = DayEnum.values()[columnIndex - 1].name)
                        Text("test")
                    }
                }
            }
        }

    }
}

fun updateUiDay(columnIndex: Int, rowIndex: Int, weekNumber: Int, viewModel: WeekViewModel) {
// TODO. Update viewModel
}

fun isSelected(
    columnIndex: Int,
    rowIndex: Int,
    weekNumber: Int,
    viewModel: WeekViewModel
): Boolean {
    // TODO. Get from viewModel
    return true
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
        Week()
    }
}