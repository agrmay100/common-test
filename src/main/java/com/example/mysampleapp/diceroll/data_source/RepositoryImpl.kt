package com.example.mysampleapp.diceroll.data_source

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat
import com.example.mysampleapp.R
import com.example.mysampleapp.diceroll.domain.Artifact
import com.example.mysampleapp.diceroll.domain.Repository

class RepositoryImpl: Repository {

    override fun getData(): List<Artifact> {
        return listOf<Artifact>(
            Artifact(image = R.drawable.dice_1, title = "sample1", subtitle = "subsample", year = 2012),
            Artifact(image = R.drawable.dice_2, title = "sample2", subtitle = "subsample2", year = 2012),
        Artifact(image = R.drawable.dice_3, title = "sample3", subtitle = "subsample3", year = 2012)
        )
    }

    private fun getImage(image: Int): Drawable?{
        return ResourcesCompat.getDrawable(Resources.getSystem(), image, null)
    }

}