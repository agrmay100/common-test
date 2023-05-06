package com.example.mysampleapp.super_hero.presentation

import android.content.res.Configuration
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysampleapp.R
import com.example.mysampleapp.super_hero.data_source.Hero
import com.example.mysampleapp.super_hero.data_source.HeroRepository
import com.example.mysampleapp.ui.theme.MysampleappTheme


@Composable
fun HeroesList(
    heroes: List<Hero>,
    modifier: Modifier = Modifier,
) {
//    val visibleState = remember {
//        MutableTransitionState(false).apply {
//            // Start the animation immediately.
//            targetState = true
//        }
//    }

    // Fade in entry animation for the entire list
//    AnimatedVisibility(
//        visibleState = visibleState,
//        enter = fadeIn(
//            animationSpec = spring(dampingRatio = DampingRatioLowBouncy)
//        ),
//        exit = fadeOut()
//    ) {
    LazyColumn {
        itemsIndexed(heroes) { index, hero ->
            HeroItem(
                item = hero,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                // Animate each list item to slide in vertically
//                        .animateEnterExit(
//                            enter = slideInVertically(
//                                animationSpec = spring(
//                                    stiffness = StiffnessVeryLow,
//                                    dampingRatio = DampingRatioLowBouncy
//                                ),
//                                initialOffsetY = { it * (index + 1) } // staggered entrance
//                            )
//                        )
            )
        }
    }
//    }
}

@Preview("Dark Theme", uiMode = Configuration.UI_MODE_TYPE_CAR)
@Composable
fun HeroesPreview() {
    MysampleappTheme() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                AppBar()
            }
        ) {
                contentPadding ->
            // Screen content
            Box(modifier = Modifier.padding(contentPadding))
            Surface(
                color = MaterialTheme.colors.background
            ) {
                /* Important: It is not a good practice to access data source directly from the UI.
                In later units you will learn how to use ViewModel in such scenarios that takes the
                data source as a dependency and exposes heroes.
                */
                HeroesList(heroes = HeroRepository.heroes)
            }
        }
    }
}

@Composable
fun AppBar(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(56.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = stringResource(id = R.string.app_bar),
            style = MaterialTheme.typography.h1
        )
    }
}
