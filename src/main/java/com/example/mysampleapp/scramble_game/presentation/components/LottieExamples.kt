package com.example.mysampleapp.scramble_game.presentation.components

import androidx.annotation.RawRes
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*

@Composable
fun LottieAnimation(
    @RawRes animation: Int, isPlaying: Boolean,
    modifier: Modifier,
    iterate: Int
) {

    // remember lottie composition ,which
    // accepts the lottie composition result
    val composition = rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(animation)
    )


    // to control the animation
    val progress = animateLottieCompositionAsState(
        // pass the composition created above
        composition.value,
        cancellationBehavior = LottieCancellationBehavior.Immediately,

        // Iterates Forever
//        iterations = LottieConstants.IterateForever,
        iterations = iterate,

        // pass isPlaying we created above,
        // changing isPlaying will recompose
        // Lottie and pause/play
        isPlaying = isPlaying,


        // pass speed we created above,
        // changing speed will increase Lottie
//        speed = speed,

        // this makes animation to restart when paused and play
        // pass false to continue the animation at which it was paused
        restartOnPlay = false

    )

    LottieAnimation(
        composition.value,
        progress.value,
        modifier = modifier.size(200.dp)
    )

//
}