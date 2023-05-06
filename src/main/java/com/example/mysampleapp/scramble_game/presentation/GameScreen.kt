package com.example.mysampleapp.scramble_game.presentation

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.airbnb.lottie.compose.LottieConstants
import com.example.mysampleapp.R
import com.example.mysampleapp.scramble_game.presentation.components.*
import com.example.mysampleapp.ui.theme.MysampleappTheme
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GameScreen(modifier: Modifier = Modifier, gameViewModel: GameViewModel = viewModel()) {
    val gameState = gameViewModel.gameState.collectAsState()
    val items = listOf("1", "3", "2")

    if (gameState.value.isGameOver) {
        LaunchedEffect(Unit) {
            delay(1000)
            gameViewModel.won.value = true
        }
    }

    Box {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            GameStatus(
                wordCount = gameState.value.wordCount,
                score = gameState.value.score
            )
            GameLayout(
                currentScrambledWord = gameState.value.currentScrambledWord,
                guessWord = gameViewModel.guessWord.value,
                guessWordChange = { gameViewModel.updateUserGuess(it) },
                onKeyboardDone = { gameViewModel.checkUserGuess() },
                isGuessWrong = gameState.value.guessedWordWrong
            )
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                OutlinedButton(
                    onClick = { gameViewModel.skipWord() },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp)
                ) {
                    Text(stringResource(R.string.skip))
                }
                Button(
                    modifier = modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(start = 8.dp),
                    onClick = { gameViewModel.checkUserGuess() }
                ) {
                    Text(
                        stringResource(R.string.submit),
                        style = TextStyle(fontWeight = FontWeight.Bold),
                        fontSize = 20.sp
                    )
                }
            }
//            Box(
//                modifier = Modifier.size(300.dp)
//            ) {
//                OptGet(modifier = modifier,
//                    word = gameViewModel.guessWord.value,
//                    wordChange = { gameViewModel.updateUserGuess(it) })
//            }

            if (gameViewModel.won.value) {
                FinalScoreDialog(
                    score = gameState.value.score,
                    onPlayAgain = { gameViewModel.resetGame() }
                )
            }
        }
        if (gameState.value.guessedWordWrong) {
            Box(
                modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
            ) {
                LottieAnimation(
                    animation = R.raw.wrong,
                    isPlaying = true,
                    modifier = modifier,
                    iterate = 1
                )
            }
        }
        if (gameState.value.isGameOver) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp), contentAlignment = Alignment.Center
            ) {
                LottieAnimation(
                    animation = R.raw.winner,
                    isPlaying = true,
                    modifier = modifier,
                    iterate = 1,
                )
            }
        }
    }
}

@Preview
@Composable
fun gamepreview() {
    MysampleappTheme() {
        Surface(
            color = MaterialTheme.colors.background
        ) {
//            GameScreen()
            var otpValue by remember {
                mutableStateOf("")
            }

            OtpTextField(
                otpText = otpValue,
                onOtpTextChange = { value, otpInputFilled ->
                    otpValue = value
                }
            )
        }

    }
}

@Composable
fun BoxTextField(list: List<String>, modifier: Modifier) {
    var value = remember { mutableStateOf("gh") }
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(
                items = list,
                key = { message ->
                    // Return a stable + unique key for the item
                    message
                }
            ) { message ->
                value.value = message
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color.Transparent),
                    contentAlignment = Alignment.Center
                ) {
                    TextField(
                        value = value.value,
                        onValueChange = {
                            if (it.length <= 1)
                                value.value = it
                        },
                    )

                }

            }
        }
    }
}

@Composable
private fun OptGet(
    modifier: Modifier, word: String,
    wordChange: (String) -> Unit
) {
//    Stringvar otp = remember {
//        mutableStateOf("")
//    }
    BasicTextField(
        value = word,
        onValueChange = wordChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text
        ),
        decorationBox = {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(word.length) { index ->
                    val char = when {
                        index >= word.length -> ""
                        else -> word[index].toString()
                    }
                    val isFocused = word.length == index
                    Text(
                        modifier = modifier
                            .width(40.dp)
                            .border(
                                if (isFocused) 2.dp else 1.dp,
                                if (isFocused) Color.DarkGray else Color.LightGray,
                                RoundedCornerShape(8.dp)
                            )
                            .padding(2.dp),
                        text = char,
                        style = MaterialTheme.typography.h4,
                        color = Color.DarkGray,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = modifier.width(8.dp))
                }
            }
        }
    )
}