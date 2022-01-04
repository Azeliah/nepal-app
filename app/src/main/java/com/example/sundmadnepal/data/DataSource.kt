package com.example.sundmadnepal.data

import com.example.sundmadnepal.R
import com.example.sundmadnepal.model.Ingredient
import com.example.sundmadnepal.model.Recipe

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
        ),
        Recipe(
            id = 5,
            name = R.string.pumpking_pudding,
            image = R.drawable.pudding_final,
            stepList = listOf("Step1: follow the instructions in the image", "Step2: look at the pretty picture"),
            ingredientList = listOf(
                Ingredient(R.drawable.pudding_ingredienses_beforemaking,"3 cups of milk"),
                                    Ingredient(R.drawable.pudding_ingredienses, "Follow the shown picture"))

        )
    )
}