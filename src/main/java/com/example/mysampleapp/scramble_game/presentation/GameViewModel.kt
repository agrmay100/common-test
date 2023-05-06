package com.example.mysampleapp.scramble_game.presentation


import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.mysampleapp.R
import com.example.mysampleapp.scramble_game.data_source.MAX_NO_OF_WORDS
import com.example.mysampleapp.scramble_game.data_source.SCORE_INCREASE
import com.example.mysampleapp.scramble_game.data_source.allWords
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel: ViewModel() {

    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState>  = _gameState.asStateFlow()

    private lateinit var currentWord: String
    // Set of words used in the game
    private var usedWords: MutableSet<String> = mutableSetOf()

    var guessWord  =  mutableStateOf("")

    var won = mutableStateOf(false)

    init {
        resetGame()
    }

    fun resetGame() {
        usedWords.clear()
        _gameState.value = GameState(currentScrambledWord = pickRandomWordAndShuffle())
    }

    private fun pickRandomWordAndShuffle(): String {
        // Continue picking up a new random word until you get one that hasn't been used before
        currentWord = allWords.random()
        return if (usedWords.contains(currentWord)) {
            pickRandomWordAndShuffle()
        } else {
            usedWords.add(currentWord)
            shuffleCurrentWord(currentWord)
        }
    }

    private fun shuffleCurrentWord(word: String): String {
        val tempWord = word.toCharArray()
        Log.d("tempword", "$tempWord")
        // Scramble the word
        tempWord.shuffle()
        Log.d("tempword", "${String(tempWord)[2]}")

        while (String(tempWord) == (word)) {
            tempWord.shuffle()
        }
        return String(tempWord)
    }

    fun updateUserGuess(guessedWord: String){
        guessWord.value = guessedWord
    }

    fun skipWord() {
        _gameState.update {
                currentState ->
            currentState.copy(
                currentScrambledWord = pickRandomWordAndShuffle(),
                guessedWordWrong = false,
                wordCount = currentState.wordCount + 1,
            )
        }
        // Reset user guess
        updateUserGuess("")
    }

    fun checkUserGuess() {
        Log.d("game", guessWord.value)
        Log.d("game", "${usedWords.size}")
        Log.d("game", "${gameState.value.wordCount}")

        if (guessWord.value == currentWord) {
            if(usedWords.size == MAX_NO_OF_WORDS){
                _gameState.update {
                        currentState ->
                    currentState.copy(
                        wordCount = currentState.wordCount + 1,
                        score = currentState.score + SCORE_INCREASE,
                        guessedWordWrong = false,
                        isGameOver = true
                    )
                }
            }
            else{
                _gameState.update {
                        currentState ->
                    currentState.copy(
                        wordCount = currentState.wordCount + 1,
                        score = currentState.score + SCORE_INCREASE,
                        currentScrambledWord = pickRandomWordAndShuffle(),
                        guessedWordWrong = false
                    )
                }
            }

        } else {
            _gameState.update { currentState ->
                currentState.copy(guessedWordWrong = true)
            }
        }
        // Reset user guess
        updateUserGuess("")
    }


}