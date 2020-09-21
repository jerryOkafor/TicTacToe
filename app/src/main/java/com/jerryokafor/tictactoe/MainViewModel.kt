package com.jerryokafor.tictactoe

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.jerryokafor.tictactoe.engine.GameUtils
import com.jerryokafor.tictactoe.engine.GameUtils.PLAYER_O
import com.jerryokafor.tictactoe.engine.GameUtils.PLAYER_X
import com.jerryokafor.tictactoe.engine.GameUtils.isBoardFull
import com.jerryokafor.tictactoe.engine.GameUtils.isGameWon

class MainViewModel : ViewModel() {

    var singlePlayer by mutableStateOf(true)
        private set

    var isGameOver by mutableStateOf(false)
        private set

    var winner by mutableStateOf("")
        private set

    var board by mutableStateOf(arrayListOf("", "", "", "", "", "", "", "", ""))
        private set

    fun play(move: Int) {
        if (board[move] == "") {
            board = ArrayList(board.toMutableList().also {
                it[move] = PLAYER_X
            })

            if (!isBoardFull(board) && !isGameWon(board, PLAYER_X)) {
                val nextMove = GameUtils.computerMove(board)

                board = ArrayList(board.toMutableList().also {
                    it[nextMove] = PLAYER_O
                })
            }
        }


        //calculate and show game result
        isGameOver = isGameWon(board, PLAYER_X) || isGameWon(board, PLAYER_O) || isBoardFull(board)
        winner = GameUtils.gameResult(board)
    }

    fun reset() {
        isGameOver = false
        board = arrayListOf("", "", "", "", "", "", "", "", "")
    }

    fun updatePlayerMode() {
        singlePlayer = singlePlayer.not()
    }


    companion object {
        const val TAG = "MainViewModel"
    }
}