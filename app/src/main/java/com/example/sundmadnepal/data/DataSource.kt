package com.example.sundmadnepal.data

import com.example.sundmadnepal.R

fun loadRecipes(): List<Recipe> {

    // This is just dummy data, until we can implement a proper repository for recipe data
    return listOf(
        Recipe(
            id = 1,
            name = R.string.dahl,
            image = R.drawable.dahl
        ),
        Recipe(
            id = 2,
            name = R.string.momo,
            image = R.drawable.momo
        ),
        Recipe(
            id = 3,
            name = R.string.newari,
            image = R.drawable.newarithali
        ),
        Recipe(
            id = 4,
            name = R.string.fried_chicken,
            image = R.drawable.fried_chicken
        )
    )
}
