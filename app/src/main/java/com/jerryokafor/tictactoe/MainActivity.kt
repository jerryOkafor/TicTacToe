package com.jerryokafor.tictactoe

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Box
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import com.jerryokafor.tictactoe.ui.TicTacToeTheme

class MainActivity : AppCompatActivity() {
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeTheme {
                Scaffold(topBar = { TicTacAppBar(mainViewModel.singlePlayer) { mainViewModel.updatePlayerMode() } }) {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
//
                        Column(
                            horizontalGravity = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround,
                            modifier = Modifier.fillMaxHeight()
                        ) {
                            ButtonGrid(board = mainViewModel.board, mainViewModel::play)
                            if (mainViewModel.isGameOver) {
                                Box {
                                    Text(
                                        text = "Game is Over: ${mainViewModel.winner}",
                                        fontSize = 20.sp
                                    )
                                }
                            }

                            ResetButton(onClick = mainViewModel::reset)

                            //Play with a friend
                            TextButton(
                                onClick = {
                                    Toast.makeText(this@MainActivity,"Coming soon",Toast.LENGTH_LONG).show()
                                },
                                modifier = Modifier.padding(16.dp).preferredHeight(50.dp),
                            ) {
                                Text(
                                    text = "Play with a friend",
                                    modifier = Modifier.padding(horizontal = 16.dp)
                                )
                            }
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun TicTacAppBar(singlePlayer: Boolean, onCheckedChange: (Boolean) -> Unit) {
    val checkedState = remember { mutableStateOf(singlePlayer) }
    TopAppBar(
        title = { Text(text = "Tic Tac Toe", color = Color.White) },
        actions = {
            Row(modifier = Modifier.padding(end = 16.dp)) {
                Text(text = if (checkedState.value) "Single Player" else "Multi Player")
                Spacer(modifier = Modifier.preferredWidth(16.dp))
                Switch(checked = checkedState.value, onCheckedChange = {
                    checkedState.value = it
                    onCheckedChange(it)
                })
            }
        }
    )
}

@Composable
fun ResetButton(onClick: () -> Unit) {
    Button(onClick = onClick, modifier = Modifier.padding(16.dp).preferredHeight(50.dp)) {
        Text(
            text = "Reset/Restart",
            style = TextStyle(textAlign = TextAlign.Center),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ButtonGrid(board: ArrayList<String>, onclick: (Int) -> Unit) {
    Column(verticalArrangement = Arrangement.SpaceEvenly) {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            ButtonExample(text = board[0]) { onclick(0) }
            ButtonExample(text = board[1]) { onclick(1) }
            ButtonExample(text = board[2]) { onclick(2) }
        }

        Row(horizontalArrangement = Arrangement.SpaceAround) {
            ButtonExample(text = board[3]) { onclick(3) }
            ButtonExample(text = board[4]) { onclick(4) }
            ButtonExample(text = board[5]) { onclick(5) }
        }
        Row {
            ButtonExample(text = board[6]) { onclick(6) }
            ButtonExample(text = board[7]) { onclick(7) }
            ButtonExample(text = board[8]) { onclick(8) }
        }
    }
}

@Composable
fun ButtonExample(text: String, onclick: () -> Unit) {
    Box(modifier = Modifier.padding(8.dp)) {
        Button(onClick = onclick, enabled = text.isBlank()) {
            Text(
                text = text,
                style = TextStyle(
                    textAlign = TextAlign.Center,
                    fontSize = 35.sp
                ),
                modifier = Modifier.padding(16.dp).preferredSize(40.dp).fillMaxHeight()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TicTacToeTheme {
        Column(horizontalGravity = Alignment.CenterHorizontally) {
            ButtonGrid(board = arrayListOf("X", "O", "X", "O", "O", "X", "", "X", "O")) {}
            ResetButton {}
        }
    }
}