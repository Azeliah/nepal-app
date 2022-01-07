package com.example.sundmadnepal.data

import com.example.sundmadnepal.R
import com.example.sundmadnepal.model.Ingredient
import com.example.sundmadnepal.model.Recipe
import com.example.sundmadnepal.model.Step

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
            stepList = listOf( Step(1, R.drawable.pudding_ingredienses, "3 cups of milk"), Step(2, R.drawable.pudding_final, "Follow the shown picture")),
            ingredientList = listOf(
                Ingredient(1, R.drawable.red_chili,"Half a red chili"),
                Ingredient(2, R.drawable.red_lentils, "1½ cup of lentils"),
                Ingredient(3, R.drawable.potatoes, "3 potatoes in either squares or whole"))

        )
    )
}