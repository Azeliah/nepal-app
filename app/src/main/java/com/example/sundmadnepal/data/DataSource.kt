package com.example.sundmadnepal.data

import android.content.Context
import com.example.sundmadnepal.R
import com.example.sundmadnepal.model.*
import com.example.sundmadnepal.model.ElementType.*

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
            stepList = listOf(
                Step(1, R.drawable.pudding_ingredienses, "Step1: 3 cups of milk"),
                Step(2, R.drawable.pudding_final, "Step2: Follow the shown picture")
            ),
            ingredientList = listOf(
                Ingredient(1, R.drawable.red_chili, "Half a red chili"),
                Ingredient(2, R.drawable.red_lentils, "1½ cup of lentils"),
                Ingredient(3, R.drawable.potatoes, "3 potatoes in either squares or whole")
            )

        )
    )
}

// Dummy data for quiz questions
fun loadQuestions(): List<QuizQuestion> {
    return listOf(
        QuizQuestion("Is this healthy?", R.drawable.fried_chicken, false),
        QuizQuestion("Is this healthy?", R.drawable.potatoes, true),
        QuizQuestion("Is it healthy for your child to eat chips", null, false)
    )
}

// Dummy data for health-info page
fun loadHealthInfo(context: Context): List<HealthInfoPage> {
    return listOf(
        HealthInfoPage(
            id = 1,
            content = listOf(
                HealthInfoElement(
                    type = PARAGRAPH,
                    content = context.getString(R.string.zeroToSix1),
                ),
                HealthInfoElement(
                    type = IMAGE,
                    content = R.drawable.woman_breastfeeding,
                ),
                HealthInfoElement(
                    type = PARAGRAPH,
                    content = context.getString(R.string.zeroToSix2),
                ),
                HealthInfoElement(
                    type = IMAGE,
                    content = R.drawable.fried_chicken,
                ),
            )
        )
    )
}
