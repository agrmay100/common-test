package com.example.mysampleapp.diceroll.userInterface

import com.example.mysampleapp.R
import com.example.mysampleapp.diceroll.domain.Artifact


data class DataState(
    val changeVal: Int = 0,
    val dataArtifact: Artifact = Artifact(image = R.drawable.dice_1, title = "sample1", subtitle = "subsample", year = 2012)
)