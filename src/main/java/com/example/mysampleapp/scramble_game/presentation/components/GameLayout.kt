package com.example.mysampleapp.scramble_game.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysampleapp.R


@OptIn(ExperimentalTextApi::class)
@Composable
fun GameLayout(
    modifier: Modifier = Modifier,
    currentScrambledWord: String,
    guessWord: String,
    guessWordChange: (String) -> Unit,
    onKeyboardDone: () -> Unit,
    isGuessWrong: Boolean
) {
    val gradientColors = listOf(Color.Cyan, Color.Blue, Color.Green /*...*/)
    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(
            text = currentScrambledWord,
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                brush = Brush.linearGradient(
                    colors = gradientColors
                )
            ),
            fontSize = 45.sp,
            modifier = modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = stringResource(R.string.instructions),
            fontSize = 17.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        OutlinedTextField(
            value = guessWord,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            onValueChange = guessWordChange,
            label = {
                if (isGuessWrong) {
                    Text(stringResource(R.string.wrong_guess))
                } else {
                    Text(stringResource(R.string.enter_your_word))
                }
            },
            isError = isGuessWrong,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { onKeyboardDone }
            ),
        )
    }
}