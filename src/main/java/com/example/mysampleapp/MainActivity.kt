package com.example.mysampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.mysampleapp.beerCache.presentation.BeerScreen
import com.example.mysampleapp.beerCache.presentation.BeerViewModel
import com.example.mysampleapp.feature_note.presentation.edit_notes.EditNoteScreen
import com.example.mysampleapp.feature_note.presentation.notes.NotesScreen
import com.example.mysampleapp.diceroll.data_source.RepositoryImpl
import com.example.mysampleapp.diceroll.userInterface.ArtifactScreen
import com.example.mysampleapp.diceroll.userInterface.ArtifactViewModel
import com.example.mysampleapp.scramble_game.presentation.GameScreen
import com.example.mysampleapp.scramble_game.presentation.components.OtpTextField
import com.example.mysampleapp.ui.theme.MysampleappTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MysampleappTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GameScreen()

//                    ArtifactScreen(viewModel = ArtifactViewModel(repo = RepositoryImpl()))
//                    val beerModel = hiltViewModel<BeerViewModel>()
//                    val beers = beerModel.beerPagerFLow.collectAsLazyPagingItems()
//
//                    val navController = rememberNavController()
//                    NavHost(
//                        navController = navController,
//                        startDestination = Screen.ArtifactScreen.route
//                    ) {
//                        composable(route = Screen.ArtifactScreen.route) {
//                            ArtifactScreen(navController = navController, viewModel = ArtifactViewModel(repo = RepositoryImpl()))
//                        }
//                        composable(route = Screen.BeerScreen.route) {
//                            BeerScreen(navController = navController, beers = beers)
//                        }
//                        composable(route = Screen.NotesScreen.route) {
//                            NotesScreen(navController = navController)
//                        }
//                        composable(
//                            route = Screen.EditNoteScreen.route +
//                                    "?noteId={noteId}&noteColor={noteColor}",
//                            arguments = listOf(
//                                navArgument(
//                                    name = "noteId"
//                                ) {
//                                    type = NavType.IntType
//                                    defaultValue = -1
//                                },
//                                navArgument(
//                                    name = "noteColor"
//                                ) {
//                                    type = NavType.IntType
//                                    defaultValue = -1
//                                },
//                            )
//                        ) {
//                            val color = it.arguments?.getInt("noteColor") ?: -1
//                            EditNoteScreen(
//                                navController = navController,
//                                noteColor = color
//                            )
//                        }
//                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MysampleappTheme {
        Greeting("Android")
    }
}