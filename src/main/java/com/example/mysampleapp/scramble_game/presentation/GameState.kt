package com.example.mysampleapp.scramble_game.presentation

data class GameState(
    val wordCount: Int = 0,
    val score: Int = 0,
    val currentScrambledWord: String = "",
    val guessedWordWrong: Boolean = false,
    val isGameOver: Boolean = false
)