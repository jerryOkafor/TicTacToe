package com.jerryokafor.tictactoe.engine

import java.util.*
import kotlin.collections.ArrayList

object GameUtils {
    const val PLAYER_X = "X" //player 1
    const val PLAYER_O = "O" //player 2 or computer

    /**
     * Determine if the board is full
     * */
    fun isBoardFull(board: ArrayList<String>): Boolean {
        for (i in board) {
            if (i != PLAYER_X && i != PLAYER_O) return false
        }
        return true
    }

    /**
     * Makes a copy of the board
     * */
    fun copyBoard(board: ArrayList<String>): ArrayList<String> {
        val newBoard = arrayListOf("", "", "", "", "", "", "", "", "")
        for (i in 0 until board.count()) {
            newBoard[i] = board[i]
        }
        return newBoard
    }

    /**
     * Choose a random move
     * */
    fun chooseRandomMove(board: ArrayList<String>, moves: ArrayList<Int>): Int {
        val possibleMoves = arrayListOf<Int>()

        for (i in moves) {
            if (board[i] == "") possibleMoves.add(i)
        }

        return if (possibleMoves.isEmpty()) {
            -1
        } else {
            val index = Random().nextInt(possibleMoves.count())
            possibleMoves[index]
        }
    }

    /**
     * Chooses a random move for the computer based on the order of
     * priority to make the computer win. It mimics AI
     * */
    fun computerMove(board: ArrayList<String>): Int {
        //check if computer can win in this move
        for (i in 0 until board.count()) {
            val copy = copyBoard(board)
            if (copy[i] == "") copy[i] = PLAYER_O

            //check for win
            if (isGameWon(copy, PLAYER_O)) return i
        }


        //check if player could win in the next move
        for (i in 0 until board.count()) {
            val copy = copyBoard(board)
            if (copy[i] == "") copy[i] = PLAYER_X

            if (isGameWon(copy, PLAYER_X)) return i
        }

        //try to make corners if it is free
        val move = chooseRandomMove(board, arrayListOf(0, 2, 6, 8))
        if (move != -1) return move

        //try to take center if it is free
        if (board[4] == "") return 4

        //finally try to make the sides
        return chooseRandomMove(board, arrayListOf(1, 3, 5, 7))
    }


    /**
     * Determines if the game is won
     * */
    fun isGameWon(board: ArrayList<String>, player: String): Boolean =
        //check rows
        if (board[0] == player && board[1] == player && board[2] == player) true
        else if (board[3] == player && board[4] == player && board[5] == player) true
        else if (board[6] == player && board[7] == player && board[8] == player) true

        //check columns
        else if (board[0] == player && board[3] == player && board[6] == player) true
        else if (board[1] == player && board[4] == player && board[7] == player) true
        else if (board[2] == player && board[5] == player && board[8] == player) true

        //check diagonals
        else if (board[6] == player && board[4] == player && board[2] == player) true
        else board[0] == player && board[4] == player && board[8] == player

    /**
     * Returns a readable game won text
     * */
    fun gameResult(board: ArrayList<String>, singleMode: Boolean): String {
        when {
            isGameWon(board, PLAYER_X) -> return "${if (singleMode) "YOU" else "PLAYER X"} Won"
            isGameWon(board, PLAYER_O) -> return "${if (singleMode) "COMPUTER" else "PLAYER O"} Won"
            isBoardFull(board) -> return "It is Tie"
        }
        return "Tie"
    }
}