package com.jerryokafor.tictactoe

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.jerryokafor.tictactoe.engine.GameUtils
import com.jerryokafor.tictactoe.engine.GameUtils.PLAYER_O
import com.jerryokafor.tictactoe.engine.GameUtils.PLAYER_X
import com.jerryokafor.tictactoe.engine.GameUtils.isBoardFull
import com.jerryokafor.tictactoe.engine.GameUtils.isGameWon

class MainViewModel : ViewModel() {

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


    companion object {
        const val TAG = "MainViewModel"
    }
}