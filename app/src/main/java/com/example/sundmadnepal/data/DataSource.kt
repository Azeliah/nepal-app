package com.example.sundmadnepal.data

import android.content.res.Resources
import com.example.sundmadnepal.R

fun loadRecipes(resources: Resources): List<Recipe> {

    // This is just dummy data, until we can implement a proper repository for recipe data
    return listOf(
        Recipe(
            id = 1,
            title = resources.getString(R.string.dahl),
            image = R.drawable.dahl
        ),
        Recipe(
            id = 2,
            title = resources.getString(R.string.momo),
            image = R.drawable.momo
        ),
        Recipe(
            id = 3,
            title = resources.getString(R.string.newari),
            image = R.drawable.newarithali
        ),
        Recipe(
            id = 4,
            title = resources.getString(R.string.fried_chicken),
            image = R.drawable.fried_chicken
        )
    )
}
