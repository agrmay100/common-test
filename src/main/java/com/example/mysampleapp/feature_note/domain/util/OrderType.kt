package com.example.mysampleapp.feature_note.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
