package com.jerryokafor.tictactoe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.jerryokafor.tictactoe.ui.TicTacToeTheme

class MainActivity : AppCompatActivity() {
    var board = arrayListOf("", "", "", "", "", "", "", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column(horizontalGravity = Alignment.CenterHorizontally) {
                        ButtonGrid()

                        ResetButton()
                    }
                }
            }
        }
    }
}

@Composable
fun ResetButton() {
    Button(onClick = {}) {
        Text(
            text = "Reset/Restart",
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ButtonGrid() {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        Column {
            ButtonExample {}
            ButtonExample {}
            ButtonExample {}
        }

        Column {
            ButtonExample {}
            ButtonExample {}
            ButtonExample {}
        }
        Column {
            ButtonExample {}
            ButtonExample {}
            ButtonExample {}
        }
    }
}

@Composable
fun ButtonExample(onclick: () -> Unit) {
    Box(modifier = Modifier.padding(8.dp)) {
        Button(onClick = onclick) {
            Text(text = "X", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TicTacToeTheme {
        Column(horizontalGravity = Alignment.CenterHorizontally) {
            ButtonGrid()
            ResetButton()
        }
    }
}