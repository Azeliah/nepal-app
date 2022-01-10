package com.example.sundmadnepal.data

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
fun loadHealthInfo(): List<HealthInfoPage> {

    val placeholderPage = listOf(
        HealthInfoElement(
            type = PARAGRAPH,
            contentRef = R.string.zeroToSix1,
        ),
        HealthInfoElement(
            type = IMAGE,
            contentRef = R.drawable.woman_breastfeeding,
        ),
        HealthInfoElement(
            type = PARAGRAPH,
            contentRef = R.string.zeroToSix2,
        ),
        HealthInfoElement(
            type = IMAGE,
            contentRef = R.drawable.fried_chicken,
        )
    )

    return listOf(
        HealthInfoPage(
            id = 1,
            image = R.drawable.health_info_general,
            title = R.string.general_information,
            content = placeholderPage,
        ),
        HealthInfoPage(
            id = 2,
            image = R.drawable.health_info_pregnant,
            title = R.string.pregnant,
            content = placeholderPage,
        ),
        HealthInfoPage(
            id = 3,
            image = R.drawable.health_info_0_6_months,
            title = R.string.zero_to_six_months,
            content = placeholderPage,
        ),
        HealthInfoPage(
            id = 4,
            image = R.drawable.health_info_6_9_months,
            title = R.string.six_to_nine_months,
            content = placeholderPage,
        ),
        HealthInfoPage(
            id = 5,
            image = R.drawable.health_info_9_12_months,
            title = R.string.nine_to_twelve_months,
            content = placeholderPage,
        ),
        HealthInfoPage(
            id = 6,
            image = R.drawable.health_info_12_24_months,
            title = R.string.twelve_to_twenty_four_months,
            content = placeholderPage,
        ),
    )
}
