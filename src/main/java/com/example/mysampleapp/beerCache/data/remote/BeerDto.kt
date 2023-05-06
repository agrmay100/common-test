package com.example.mysampleapp.beerCache.data.remote

data class BeerDto(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val imageUrl: String?,
    val firstBrewed: String?
)
