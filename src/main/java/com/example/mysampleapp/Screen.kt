package com.example.mysampleapp

sealed class Screen(val route: String) {
    object NotesScreen: Screen("notes_screen")
    object EditNoteScreen: Screen("edit_note_screen")
    object ArtifactScreen: Screen(route = "artifacts")
    object BeerScreen: Screen(route = "beerCache")
}