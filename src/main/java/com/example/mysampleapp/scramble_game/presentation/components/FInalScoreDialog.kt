package com.example.mysampleapp.scramble_game.presentation.components

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mysampleapp.R


@Composable
fun FinalScoreDialog(
    onPlayAgain: () -> Unit,
    modifier: Modifier = Modifier,
    score: Int
) {
    val activity = (LocalContext.current as Activity)

    AlertDialog(
        onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            // button. If you want to disable that functionality, simply use an empty
            // onCloseRequest.
        },
        title = { Text(stringResource(R.string.congratulations)) },

        text = {
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                LottieAnimation(
                    animation = R.raw.winner,
                    isPlaying = true,
                    modifier = modifier
                        .size(100.dp)
                        .align(alignment = Alignment.Center),
                    iterate = 1,
                )
                Text(stringResource(R.string.you_scored, score), textAlign = TextAlign.Start)
            }

        },
        modifier = modifier,
        dismissButton = {
            TextButton(
                onClick = {
                    activity.finish()
                }
            ) {
                Text(text = stringResource(R.string.exit))
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onPlayAgain()
                }
            ) {
                Text(text = stringResource(R.string.play_again))
            }
        }
    )
}