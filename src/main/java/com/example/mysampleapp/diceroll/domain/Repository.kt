package com.example.mysampleapp.diceroll.domain

interface Repository {

    fun getData(): List<Artifact>
}