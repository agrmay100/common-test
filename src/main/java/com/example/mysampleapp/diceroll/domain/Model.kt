package com.example.mysampleapp.diceroll.domain

import androidx.annotation.DrawableRes
import com.example.mysampleapp.R

data class Artifact(
    @DrawableRes val image: Int = R.drawable.dice_1,
    val title: String = "initial title",
    val subtitle: String = "Initial Subtitle",
    val year: Int = 2022
)
