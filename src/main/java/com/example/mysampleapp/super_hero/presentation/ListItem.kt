package com.example.mysampleapp.super_hero.presentation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysampleapp.R
import com.example.mysampleapp.super_hero.data_source.Hero
import com.example.mysampleapp.ui.theme.MysampleappTheme


@Composable
fun HeroItem(item: Hero, modifier: Modifier = Modifier) {

    Card(
        elevation = 2.dp,
        modifier = modifier
            .clip(RoundedCornerShape(16.dp)),

        ) {
        Row(
            modifier = Modifier.padding(16.dp)
        ) {

            Column(
                modifier = Modifier.weight(1f).align(Alignment.CenterVertically)
            ) {
                Text(
                    text = stringResource(id = item.nameRes),
                    style = MaterialTheme.typography.h3
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = stringResource(id = item.descriptionRes),
                    style = MaterialTheme.typography.body1
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
//            Box(modifier = ){
                Image(
                    painter = painterResource(id = item.imageRes),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .clip(RoundedCornerShape(8.dp))
                        .size(72.dp)
                )


        }
    }
}


@Preview("Light Theme")
@Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroPreview() {
    val hero = Hero(
        R.string.hero1,
        R.string.description1,
        R.drawable.android_superhero1
    )
    MysampleappTheme() {
        HeroItem(item = hero)
    }
}