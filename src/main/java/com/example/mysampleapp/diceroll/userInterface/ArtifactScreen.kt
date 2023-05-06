package com.example.mysampleapp.diceroll.userInterface

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mysampleapp.Screen

@Composable
fun ArtifactScreen(
    navController: NavController,
    viewModel: ArtifactViewModel
) {
    val state = viewModel.state.value
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState
    ) { contentPadding ->
        // Screen content
        Box(modifier = Modifier.padding(contentPadding))
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)

        ) {
            Image(
                painter = painterResource(id = state.dataArtifact.image),
                contentDescription = "myImage",
                modifier = Modifier.height(200.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(text = state.dataArtifact.title)
                Text(text = state.dataArtifact.subtitle)
            }
            
            Button(onClick = {
//                viewModel.event()
                navController.navigate(Screen.BeerScreen.route)
            }) {

                Text(text = "submit")

            }
        }
    }
}