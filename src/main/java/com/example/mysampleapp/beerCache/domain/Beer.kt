package com.example.mysampleapp.beerCache.domain

data class Beer(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val imageUrl: String?,
    val firstBrewed: String?

)
