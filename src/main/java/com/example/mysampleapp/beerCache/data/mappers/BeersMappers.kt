package com.example.mysampleapp.beerCache.data.mappers

import com.example.mysampleapp.beerCache.data.local.BeerEntity
import com.example.mysampleapp.beerCache.data.remote.BeerDto
import com.example.mysampleapp.beerCache.domain.Beer

fun BeerDto.toBeerEntity(): BeerEntity{
    return BeerEntity(
        id = id,
        name = name,
        description = description,
        tagline = tagline,
        imageUrl = imageUrl,
        firstBrewed = firstBrewed
    )
}

fun BeerEntity.toBeer(): Beer{
    return Beer(
        id = id,
        name = name,
        description = description,
        tagline = tagline,
        imageUrl = imageUrl,
        firstBrewed = firstBrewed
    )
}